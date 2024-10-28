package com.example.week5_baru.repository

import com.example.week5_baru.model.Movie
import com.example.week5_baru.model.NowPlaying
import com.example.week5_baru.model.Result
import com.example.week5_baru.service.MovieDBService
import java.text.SimpleDateFormat

class MovieDBRepositories(private val movieDBService: MovieDBService) {

    suspend fun getNowPlaying(page: Int = 1, language: String = "en-US"): List<Result>{
        val listResult = movieDBService.getNowPlaying(page,language).results
        return  listResult

    }

    suspend fun getMovieDetail(movieId: Int): Movie{
        val respond = movieDBService.getDetailMovie(movieId)

        val movie = Movie(
            overview = respond.overview,
            posterPath = respond.poster_path,
            releaseDate = SimpleDateFormat("yyyy-MM-dd").parse(respond.release_date),
            title = respond.title,
            voteAverage = respond.vote_average.toFloat(),
            voteCount = respond.vote_count,
            isLiked = false
                )
        return movie
    }


}