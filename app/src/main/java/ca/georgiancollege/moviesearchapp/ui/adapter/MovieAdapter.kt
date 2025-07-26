package ca.georgiancollege.moviesearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.georgiancollege.moviesearchapp.data.Movie
import ca.georgiancollege.moviesearchapp.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso

class MovieAdapter(private val onClick: (Movie) -> Unit)
   : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

      private var movies = listOf<Movie>()

   fun submitList(list: List<Movie>){
      movies = list
      notifyDataSetChanged()
   }

   inner class MovieViewHolder(val binding: ItemMovieBinding)
      : RecyclerView.ViewHolder(binding.root){

   fun bind(movie: Movie){
      binding.tvTitle.text = movie.Title
      binding.tvYear.text = movie.Year
      binding.tvType.text = movie.Type

      Picasso.get().load(movie.Poster).into(binding.imgPoster)

      binding.root.setOnClickListener{
         onClick(movie)
      }
   }
}
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
   val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
   return MovieViewHolder(binding)
}
override fun onBindViewHolder(holder: MovieViewHolder, position: Int){
   holder.bind(movies[position])
}
override fun getItemCount(): Int = movies.size
}