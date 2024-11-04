package com.example.week5_baru.repository

import com.example.week5_baru.service.MovieDBService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDBContainer {

//    static variable yang bisa diakses dari mana saja
    companion object {
        val BASE_IMG = "https://image.tmdb.org/t/p/w500"
    }


    private val BASE_URL = "https://api.themoviedb.org/3/movie/"
    private val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2ODY0NDljYTg3ODU2YWQ2NmE1ZTYzYjg3OWJhOGQxNyIsIm5iZiI6MTczMDY5MjkxNi42MzE0NjczLCJzdWIiOiI2NzFmMDFmOTZkNmI3MDVkYzg3MWUxNDAiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0._xx88-LLcljaoBCjacCHgXMVLT9HCXebgepZJ-LcvT4"

//
    private val client = OkHttpClient.Builder()
    .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
    .build()

    //    LIBRARY UNTUK CONNECT KE API NAMANYA RETROFIT SUPAYA BISA COMMUNICATION
    private val retrofit = Retrofit.Builder()
//        KARENA BAHASA BERBEDA JADI MENGGUNAKAN GSON SEBAGAI PERANTARANYA. PAKE GSON GA PERLU COMPLIE LAGI DI REPOSITORYNYA
        .addConverterFactory(GsonConverterFactory.create())
//        SPESIFIK MAU CONNECT KEMANA
        .baseUrl(BASE_URL)
//       GENERATE CLIENT APA AJA YANG MAU DILEMPAR DALAM API TERSEBUT
        .client(client)
        .build()

    private val retrofitService: MovieDBService by lazy {
        retrofit.create(MovieDBService::class.java)
    }

    val movieDBRepository : MovieDBRepositories by lazy {
        MovieDBRepositories(retrofitService)
    }



}