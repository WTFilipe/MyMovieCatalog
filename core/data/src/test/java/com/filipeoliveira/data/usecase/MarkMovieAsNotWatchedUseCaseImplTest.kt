package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.FakeMovieRepository
import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.error.InvalidMovieIdError
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.AddToFavoriteUseCase
import com.filipeoliveira.domain.usecase.MarkMovieAsNotWatchedUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MarkMovieAsNotWatchedUseCaseImplTest {

    private lateinit var fakeRepository: MovieRepository
    private lateinit var useCase: MarkMovieAsNotWatchedUseCase

    @Before
    fun setUp() {
        fakeRepository = FakeMovieRepository()
        useCase = MarkMovieAsNotWatchedUseCaseImpl(fakeRepository)

        val list = List(10){
            Movie(
                adult = false,
                id = it,
                original_title = it.toString(),
                overview = it.toString(),
                poster_path = it.toString(),
                release_date = it.toString(),
                title = it.toString(),
                vote_average = it.toDouble(),
                vote_count = it,
                isWatched = it % 2 == 0,
                isFavorite = it % 2 == 1
            )
        }

        (fakeRepository as FakeMovieRepository).addMovieList(list)
    }

    @Test
    fun `when marking a movie as not watched, its watched field should be false`() = runBlocking {
        val watchedMovie = (fakeRepository as FakeMovieRepository).getPopularMoviesWithoutPaging().first().first { it.isWatched }

        useCase.execute(watchedMovie)

        val nowNotWatchedMovie = (fakeRepository as FakeMovieRepository).getPopularMoviesWithoutPaging().first().first { it.id == watchedMovie.id }

        assertEquals(false, nowNotWatchedMovie.isWatched)
    }

    @Test
    fun `when marking a invalid movie as not watched, should throw error`() = runBlocking {
        val movie = (fakeRepository as FakeMovieRepository).getPopularMoviesWithoutPaging().first().first().copy(id = -1)

        try {
            useCase.execute(movie)
            fail("InvalidMovieIdError was expected, but no Exception was found")
        } catch (e: Exception){
            assertTrue(e is InvalidMovieIdError)
        }
    }
}