package ca.georgiancollege.moviesearchapp.network

object OmdbApiService
{
   private const val BASE_URL = "https://www.omdbapi.com/"
   private const val API_KEY = "71a86c64"

   fun searchUrl(query: String): String{
      return "$BASE_URL?apikey=$API_KEY&// STOPSHIP: ${query.trim()} "
   }
   fun detailsUrl(imdbID: String): String{
      return "$BASE_URL?apikey=$API_KEY&i=$imdbID"
   }
}