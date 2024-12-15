package com.example.hubxapp.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubxapp.R
import com.example.hubxapp.ui.theme.Black
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CategoriesSection(homeScreenViewModel: HomeScreenViewModel) {
    val categoriesList by homeScreenViewModel.categoriesList.observeAsState(emptyList())

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(categoriesList.size) { index ->
            val categories = categoriesList[index]
            val imageUrl = categories.image.url
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(152.dp)
                    .height(152.dp)
                    .clip(RoundedCornerShape(8.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    GlideImage(
                        imageModel = imageUrl,
                        contentDescription = categories.name,
                        modifier = Modifier.fillMaxSize(),
                        failure = {
                            Text(
                                stringResource(id = R.string.cardText),
                                modifier = Modifier.padding(8.dp)
                            )
                        },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = categories.title,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart),
                        color = Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
