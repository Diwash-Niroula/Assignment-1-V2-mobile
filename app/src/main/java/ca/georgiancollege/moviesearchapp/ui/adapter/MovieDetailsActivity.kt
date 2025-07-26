package ca.georgiancollege.moviesearchapp.ui.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.georgiancollege.moviesearchapp.databinding.ActivityMovieDetailsBinding
import ca.georgiancollege.moviesearchapp.repository.MovieRepository
import com.squareup.picasso.Picasso

class MovieDetailsActivity: AppCompatActivity()
{
   private lateinit var binding: ActivityMovieDetailsBinding
   private val repo = MovieRepository()

   override fun onCreate(savedInstanceState: Bundle?)
   {
       super.onCreate(savedInstanceState)
      binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
      setContentView(binding.root)

      binding.btnBackToSearch.setOnClickListener {
         finish()
      }

      val imdbId = intent.getStringExtra("movie_id")

      if(imdbId != null){
         repo.getMovieDetails(imdbId) { details ->
            if (details == null) return@getMovieDetails
            runOnUiThread {
               binding.tvTitle.text = details.Title
               binding.tvYear.text = details.Year
               binding.tvDirector.text = details.Director
               binding.tvPlot.text = details.Plot
               Picasso.get().load(details.Poster).into(binding.imgPoster)
            }
         }
      }

   }
}