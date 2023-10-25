package com.filipeoliveira.data.mapper

import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.data.local.model.MovieDB
import com.filipeoliveira.data.remote.model.MovieRemote

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
    vote_count = vote_count,
    alreadyWatched = isWatched
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