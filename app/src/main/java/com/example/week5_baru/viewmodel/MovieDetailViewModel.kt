package com.example.week5_baru.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week5_baru.data.DataSource
import com.example.week5_baru.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieDetailViewModel: ViewModel() {

    private val _movie = MutableStateFlow(Movie()) // Default empty Movie object
    val movie: StateFlow<Movie> = _movie

    fun setMovie(title: String) {
        // Fetching data from the data source
        val movies = DataSource().loadMovie()
        for (movie in movies) {
            if (movie.title == title) {
                _movie.value = movie.copy(
                    overview = movie.overview,
                    posterPath = movie.posterPath,
                    releaseDate = movie.releaseDate,
                    title = movie.title,
                    voteAverage = movie.voteAverage,
                    voteCount = movie.voteCount,
                    isLiked = movie.isLiked
                )
            }
        }
    }
}
