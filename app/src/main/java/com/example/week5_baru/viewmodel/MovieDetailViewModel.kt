package com.example.week5_baru.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5_baru.data.DataSource
import com.example.week5_baru.model.Movie
import com.example.week5_baru.repository.MovieDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel: ViewModel() {

    private val _movie = MutableStateFlow(Movie()) // Default empty Movie object
    val movie: StateFlow<Movie> = _movie

    fun setMovie(id: Int) {
        viewModelScope.launch {
            val movie = MovieDBContainer().movieDBRepository.getMovieDetail(id)
            _movie.value = _movie.value.copy(
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
