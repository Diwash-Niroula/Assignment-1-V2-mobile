package ca.georgiancollege.moviesearchapp.repository

import ca.georgiancollege.moviesearchapp.data.Movie
import ca.georgiancollege.moviesearchapp.data.MovieDetails
import ca.georgiancollege.moviesearchapp.data.OmdbResponse
import ca.georgiancollege.moviesearchapp.network.OmdbApiService
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MovieRepository
{
   private val client = OkHttpClient()

   // Search movie by title
   fun searchMovies(query: String, callback: (List<Movie>?) -> Unit)
   {
      val url = OmdbApiService.searchUrl(query)
      val request = Request.Builder().url(url).build()

      client.newCall(request).enqueue(object : Callback
      {
         override fun onFailure(call: Call, e: IOException)
         {
            e.printStackTrace()
            callback(null)
         }

         override fun onResponse(call: Call, response: Response)
         {
            val json = response.body?.string()
            try
            {
               val result = Gson().fromJson(json, OmdbResponse::class.java)
               callback(result.Search)
            }
            catch (e: Exception)
            {
               e.printStackTrace()
               callback(null)
            }
         }
      })
   }

   // get full movie details from IMDB ID
   fun getMovieDetails(id: String, callback: (MovieDetails?) -> Unit)
   {
      val url = OmdbApiService.detailsUrl(id)
      val request = Request.Builder().url(url).build()

      client.newCall(request).enqueue(object : Callback
      {
         override fun onFailure(call: Call, e: IOException)
         {
            e.printStackTrace()
            callback(null)
         }

         override fun onResponse(call: Call, response: Response)
         {
            val json = response.body?.string()
            try
            {
               val result = Gson().fromJson(json, MovieDetails::class.java)
               callback(result)
            }
            catch (e: Exception)
            {
               e.printStackTrace()
               callback(null)
            }
         }
      })
   }
}