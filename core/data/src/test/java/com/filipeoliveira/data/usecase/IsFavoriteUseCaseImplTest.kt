package com.filipeoliveira.data.usecase

import com.filipeoliveira.data.FakeMovieRepository
import com.filipeoliveira.data.MovieRepository
import com.filipeoliveira.domain.model.Movie
import com.filipeoliveira.domain.usecase.GetFavoriteMoviesUseCase
import com.filipeoliveira.domain.usecase.IsFavoriteUseCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class IsFavoriteUseCaseImplTest {

    private lateinit var fakeRepository: MovieRepository
    private lateinit var useCase: IsFavoriteUseCase

    @Before
    fun setUp() {
        fakeRepository = FakeMovieRepository()
        useCase = IsFavoriteUseCaseImpl(fakeRepository)

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
    fun `when a movie is Favorite, should return true`() = runBlocking {
        val movie = (fakeRepository as FakeMovieRepository).getPopularMoviesWithoutPaging().first().first { it.isFavorite }

        val isFavorite = useCase.execute(movie).first()

        assertTrue(isFavorite)
    }

    @Test
    fun `when a movie is not Favorite, should return false`() = runBlocking {
        val movie = (fakeRepository as FakeMovieRepository).getPopularMoviesWithoutPaging().first().first { !it.isFavorite }

        val isFavorite = useCase.execute(movie).first()

        assertEquals(false, isFavorite)
    }
}