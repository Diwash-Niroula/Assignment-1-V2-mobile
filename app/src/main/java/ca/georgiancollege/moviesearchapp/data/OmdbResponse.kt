package ca.georgiancollege.moviesearchapp.data

import com.google.gson.annotations.SerializedName

data class OmdbResponse
   (
   @SerializedName("Search")
   val Search: List<Movie>? = null,

   @SerializedName("Response")
   val response: String? = null,

   @SerializedName("Error")
   val error: String? = null
)