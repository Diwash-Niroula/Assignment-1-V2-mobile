package ca.georgiancollege.moviesearchapp.ui.adapter

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ca.georgiancollege.moviesearchapp.databinding.ActivityMainBinding
import ca.georgiancollege.moviesearchapp.viewmodel.MovieViewModel

class  MainActivity : AppCompatActivity()
{
   private lateinit var binding: ActivityMainBinding
   private lateinit var viewModel: MovieViewModel
   private lateinit var movieAdapter: MovieAdapter

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

      viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

      movieAdapter = MovieAdapter {movie ->

         val intent = Intent(this, MovieDetailsActivity::class.java)
         intent.putExtra("movie_id",movie.imdbID)
         startActivity(intent)
      }
      binding.rvMovies.apply{
         layoutManager = LinearLayoutManager(this@MainActivity)
         adapter = movieAdapter
      }

      viewModel._movies.observe(this){ movies ->
         movieAdapter.submitList(movies)
      }

      binding.btnSearch.setOnClickListener {
         val query = binding.etSearch.text.toString()
         if (query.isNotBlank()){
           Log.d("SEARCH_BUTTON","Clicked with query: $query")
            viewModel.searchMovies(query)
         }
      }
   }
}