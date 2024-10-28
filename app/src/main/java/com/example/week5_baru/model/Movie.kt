package com.example.week5_baru.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

data class Movie(
    val overview: String = "",
    val posterPath: String = "",
    val releaseDate: Date?= null,
    val title: String = "",
    val voteAverage: Float = 0f,
    val voteCount: Int = 0,
    var isLiked: Boolean = false
) {

    @SuppressLint("SimpleDateFormat")
    fun getYear(): String {
        return SimpleDateFormat("yyyy").format(releaseDate)
    }
}