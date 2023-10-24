package com.filipeoliveira.mymoviecatalog.data.mapper

import com.filipeoliveira.mymoviecatalog.data.Movie
import com.filipeoliveira.mymoviecatalog.data.local.model.MovieDB
import com.filipeoliveira.mymoviecatalog.data.remote.model.MovieRemote

fun MovieRemote.toMovie() = Movie(
    adult = adult,
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    vote_average = vote_average,
    vote_count = vote_count
)

fun Movie.toMovieDB() = MovieDB(
    adult = adult,
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    vote_average = vote_average,
    vote_count = vote_count
)

fun MovieDB.toMovie() = Movie(
    adult = adult,
    id = id,
    original_title = original_title,
    overview = overview,
    poster_path = poster_path,
    release_date = release_date,
    title = title,
    vote_average = vote_average,
    vote_count = vote_count,
    isWatched = alreadyWatched
)