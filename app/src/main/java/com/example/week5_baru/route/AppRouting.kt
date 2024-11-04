package com.example.week5_baru.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.week5_baru.view.ListMovieView
import com.example.week5_baru.view.MovieDetailView

enum class listScreen(){
    ListMovie,
    MovieDetail,

}

@Composable
fun AppRouting(){
    val navController = rememberNavController()

    Scaffold(
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = listScreen.ListMovie.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = listScreen.ListMovie.name) {
                ListMovieView(navController = navController)
            }

            composable(route = listScreen.MovieDetail.name+"/{id}",
                arguments = listOf(
                    navArgument("id"){
                        type = NavType.IntType
                    }
                )
                ) {
                backStackEntry ->
                val id= backStackEntry.arguments?.getInt("id")
                MovieDetailView(id!!)
            }
        }
    }
}