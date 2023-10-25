package com.filipeoliveira.data

import com.filipeoliveira.data.local.MovieDAO
import com.filipeoliveira.data.local.MovieLocalData
import com.filipeoliveira.data.local.MovieLocalDataImpl
import com.filipeoliveira.data.local.model.MovieDB
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class MovieLocalDataTest {

    @Mock
    private lateinit var movieDAO: MovieDAO

    private lateinit var movieLocalData: MovieLocalData

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        movieLocalData = MovieLocalDataImpl(movieDAO)
    }

    @Test
    fun `get Favorite Movies should return flow of favorite movies list`() = runTest {
        //Arrange
        val favoriteMovies = flowOf(
            List(3) {
                MovieDB(
                    adult = false,
                    id = 926393,
                    original_title = "The Equalizer 3",
                    overview = "Sentindo-se em casa no sul da Itália, o ex-agente Robert McCall logo descobre que seus novos amigos estão sob o controle dos chefes do crime local.  À medida que os acontecimentos se tornam mortais, McCall sabe o que tem de fazer: tornar-se o protetor dos seus amigos, enfrentando a máfia.",
                    poster_path = "/AnJOKbSQsp0QqiUhsQooqFRjPsD.jpg",
                    release_date = "2023-08-30",
                    title = "O Protetor: Capítulo Final",
                    vote_count = 23,
                    vote_average = 4.7
                )
            }
        )

        Mockito.`when`(movieDAO.getFavoriteMovies()).thenReturn(favoriteMovies)

        //Act
        val result = movieLocalData.getFavoriteMoviesList().toList().first()

        //Assert
        assertEquals(3, result.size)
    }

    @Test
    fun `get Favorite Movies should return empty`() = runTest {
        //Arrange
        val favoriteMovies = flowOf(
            listOf<MovieDB>()
        )

        Mockito.`when`(movieDAO.getFavoriteMovies()).thenReturn(favoriteMovies)

        //Act
        val result = movieLocalData.getFavoriteMoviesList().toList().first()

        //Assert
        assertEquals(0, result.size)
    }

}