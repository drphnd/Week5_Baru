package com.example.week5_baru.view


import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.week5_baru.route.listScreen
import com.example.week5_baru.viewmodel.ListMovieViewModel

@Composable
fun ListMovieView(
    modifier: Modifier = Modifier,
    viewModel: ListMovieViewModel = viewModel(),
    navController: NavController? = null
){

    val movies by viewModel.movies.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(movies){ movie ->
            MovieCard(
                movie,
                onLikeClick = { viewModel.toggleButtonLike(movie) },
                onCardClick = { navController?.navigate(listScreen.MovieDetail.name+"/${movie.id}") }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListMoviePreview(){
    ListMovieView()
}