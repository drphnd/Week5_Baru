package com.example.week5_baru.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5_baru.data.DataSource
import com.example.week5_baru.model.Movie
import com.example.week5_baru.model.Result
import com.example.week5_baru.repository.MovieDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListMovieViewModel: ViewModel() {

    // Set
    private val _movies = MutableStateFlow<List<Result>>(emptyList())
    // Get
    val movies: StateFlow<List<Result>> = _movies

    init {
        loadMovies()
    }

    private fun loadMovies(){

        viewModelScope.launch {
            val data = MovieDBContainer().movieDBRepository.getNowPlaying(1)
            _movies.value = data
        }
    }

    fun toggleButtonLike(movie: Result){
        _movies.value = _movies.value.map {
            if (it.title == movie.title){
                it.copy()
            }else{
                it
            }
        }
    }
}