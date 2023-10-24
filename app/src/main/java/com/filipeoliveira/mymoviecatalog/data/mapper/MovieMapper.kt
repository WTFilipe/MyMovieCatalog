package com.filipeoliveira.mymoviecatalog.data.mapper

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemote

fun MovieRemote.toMovie() = Movie(
    adult = adult,
    backdrop_path = backdrop_path,
    genre_ids = genre_ids,
    id = id,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    popularity = popularity,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    video = video,
    vote_average = vote_average,
    vote_count = vote_count
)