package com.example.week5_baru.service

import com.example.week5_baru.model.NowPlaying

import com.example.week5_baru.model.Result
import org.intellij.lang.annotations.Language
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
//listing api end poinnya dan parameter yang perlu diend poin dan return nya apa
interface MovieDBService {

    @GET("now_playing")
    suspend fun getNowPlaying(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ):NowPlaying

    @GET("popular")
    suspend fun getPopular(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ):NowPlaying


    @GET("{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId:Int
    ): Result

}