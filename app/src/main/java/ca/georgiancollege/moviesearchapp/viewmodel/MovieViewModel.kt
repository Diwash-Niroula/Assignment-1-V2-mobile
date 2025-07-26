package ca.georgiancollege.moviesearchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.georgiancollege.moviesearchapp.data.Movie
import ca.georgiancollege.moviesearchapp.data.MovieDetails
import ca.georgiancollege.moviesearchapp.repository.MovieRepository

class MovieViewModel: ViewModel()
{
   private val repo = MovieRepository()

   internal val _movies = MutableLiveData<List<Movie>>()
   val movies: LiveData<List<Movie>> get() = _movies

   private val _movieDetails = MutableLiveData<MovieDetails>()
   val movieDetails: LiveData<MovieDetails> = _movieDetails

   fun searchMovies(query: String){
      repo.searchMovies(query){ result ->
         result?.let {
            _movies.postValue(it)
         }
      }
   }
   fun loadMovieDetails(id: String){
      repo.getMovieDetails(id) { details ->
         details?.let {
            _movieDetails.postValue(it)
         }
      }
   }
}