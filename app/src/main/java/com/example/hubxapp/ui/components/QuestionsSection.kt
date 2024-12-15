package com.example.hubxapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.hubxapp.data.entity.Questions
import com.example.hubxapp.ui.theme.White
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun QuestionsSection(homeScreenViewModel: HomeScreenViewModel) {
    val questionsList by homeScreenViewModel.questionsList.observeAsState(emptyList())

    LazyRow(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(questionsList.size) { index ->
            QuestionCard(question = questionsList[index]) // Her bir kartı render ettik
        }
    }
}

@Composable
fun QuestionCard(question: Questions) {
    Card(
        modifier = Modifier
            .width(250.dp)
            .height(160.dp) ,
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            GlideImage(
                imageModel = question.image_uri,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = question.title,
                    color = White,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

