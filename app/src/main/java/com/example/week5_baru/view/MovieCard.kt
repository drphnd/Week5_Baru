package com.example.week5_baru.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week5_baru.data.DataSource
import com.example.week5_baru.model.Movie

@Composable
fun MovieCard(
    movie: Movie,
    onLikeClick: () -> Unit = {},
    onCardClick: () -> Unit = {}
){
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable(
                onClick = onCardClick
            ),
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        onClick =  onCardClick
    ) {
        Column {
            Box(
                contentAlignment = Alignment.BottomEnd
            ){
                Image(
                    painter = painterResource(movie.posterPath.toInt()),
                    contentDescription = "Movie Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.FillWidth
                )

                FloatingActionButton(
                    onClick = onLikeClick,
                    shape = CircleShape,
                    modifier = Modifier.padding(end = 4.dp, bottom = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Fav",
                        tint = if(movie.isLiked){
                            Color(0xFFEC407A)
                        }else{
                            Color(0xFF787878)
                        }
                    )
                }
            }

            Row(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(2f)
                        .height(60.dp)
                )

                Text(
                    text = "(${movie.getYear()})",
                    textAlign = TextAlign.Right,
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Star",
                    tint = Color(0xFFFDCC0D)
                )
                Text(
                    text = "${movie.voteAverage}/10.0",
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Text(
                text = movie.overview,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieCardPreview(){
    MovieCard(DataSource().loadMovie()[3])
}