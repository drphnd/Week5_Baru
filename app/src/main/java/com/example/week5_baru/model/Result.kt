package com.example.week5_baru.model

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

data class Result(
    val backdrop_path: String,
    val id: Int,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
) {
    @SuppressLint("SimpleDateFormat")
    fun getYear(): String {
        return SimpleDateFormat("yyyy").format(release_date)
    }
}