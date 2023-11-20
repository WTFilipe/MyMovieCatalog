package com.filipeoliveira.data

import com.filipeoliveira.data.remote.MovieRemoteData
import com.filipeoliveira.data.remote.MovieRemoteDataImpl
import com.filipeoliveira.data.remote.MovieService
import com.filipeoliveira.data.remote.model.MovieRemote
import com.filipeoliveira.data.remote.model.MovieRemoteResponse
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
class MovieRemoteDataTest {

    @Mock
    private lateinit var service: MovieService

    private lateinit var movieRemoteData: MovieRemoteData

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        movieRemoteData = MovieRemoteDataImpl(service)
    }

    @Test
    fun `get Popular Movies should return MovieRemoteResponse`() = runTest {
        //Arrange
        val movieRemoteResponse = MovieRemoteResponse(
            page = 1,
            results = List(3) {
                MovieRemote(
                    false,
                    "",
                    emptyList(),
                    1,
                    "",
                    "",
                    "",
                    0.0,
                    "",
                    "",
                    "",
                    false,
                    0.0,
                    0
                )
            },
            total_pages = 0,
            total_results = 0
        )
        Mockito.`when`(service.getPopularMovies(1)).thenReturn(movieRemoteResponse)

        // Act
        val result = movieRemoteData.getPopularMovies()

        //Assert
        assertEquals(3, result.results.size)
    }
}