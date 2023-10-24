package com.filipeoliveira.mymoviecatalog.data

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {
    fun getPosterURL() = "https://image.tmdb.org/t/p/w500${poster_path}"
    fun getBackdropURL() = "https://image.tmdb.org/t/p/w500${backdrop_path}"
    fun getReleaseYear() = release_date.substringBefore("-")
}