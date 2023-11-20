package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.FakeMovieRepository
import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.Result
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.GetFavoriteMoviesUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetFavoriteMoviesUseCaseImplTest {

    private lateinit var fakeRepository: MovieRepository
    private lateinit var useCase: GetFavoriteMoviesUseCase

    @Before
    fun setUp() {
        fakeRepository = FakeMovieRepository()
        useCase = GetFavoriteMoviesUseCaseImpl(fakeRepository)

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
    fun `get Favorite Movies should not return any no favorite movies`() = runBlocking {
        val favoriteMoviesResult = useCase.execute().first()

        assertTrue(favoriteMoviesResult is Result.Success)

        val favoriteMovieList = (favoriteMoviesResult as Result.Success).data

        val isThereAnyNoFavorite = favoriteMovieList.any { !it.isFavorite }

        assertEquals(false, isThereAnyNoFavorite)
    }

    @Test
    fun `when theres no response, should return result error`() = runBlocking {
        (fakeRepository as FakeMovieRepository).addMovieList(emptyList())

        val favoriteMoviesResult = useCase.execute().first()

        assertTrue(favoriteMoviesResult is Result.Error)
    }
}