package com.example.week5_baru.viewmodel

import androidx.lifecycle.ViewModel
import com.example.week5_baru.data.DataSource
import com.example.week5_baru.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListMovieViewModel: ViewModel() {

    // Set
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    // Get
    val movies: StateFlow<List<Movie>> = _movies

    init {
        loadMovies()
    }

    private fun loadMovies(){
        _movies.value = DataSource().loadMovie()
    }

    fun toggleButtonLike(movie: Movie){
        _movies.value = _movies.value.map {
            if (it.title == movie.title){
                it.copy(isLiked = !it.isLiked)
            }else{
                it
            }
        }
    }
}