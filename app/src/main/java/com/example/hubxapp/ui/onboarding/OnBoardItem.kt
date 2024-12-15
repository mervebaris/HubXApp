package com.example.hubxapp.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubxapp.data.entity.OnBoardModel
import com.example.hubxapp.ui.theme.Black
import com.example.hubxapp.ui.theme.Gray
import com.example.hubxapp.ui.theme.LightGray
import com.example.hubxapp.ui.theme.LightGreen
import com.example.hubxapp.ui.theme.MainColor
import com.example.hubxapp.ui.theme.White
import kotlinx.coroutines.launch


//The displayed page design is populated with the content of the onBoardModel
@Composable
fun OnBoardItem(onBoardModel: OnBoardModel, pagerState:PagerState) {
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {

        //Image, Title, and Subtitle Area
        //The title and subtitle are placed on the image and occupy 80% of the screen
        Box(
            modifier = Modifier.fillMaxSize().weight(80f),
            contentAlignment = Alignment.TopCenter
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = onBoardModel.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.width(320.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 16.dp, end = 32.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = onBoardModel.title, style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = onBoardModel.subtitle,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Gray,
                    )
                )
            }
        }

        //The Button, Description, and Indicator Area occupy 20% of the space
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = {
                    //Pager page transition coding
                    val nextPage = pagerState.currentPage + 1
                    coroutineScope.launch { pagerState.animateScrollToPage(nextPage) }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MainColor),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(all = 10.dp)
                    .width(380.dp)
                    .height(60.dp)
            ) {
                Text(text = onBoardModel.buttonTitle, color = White, fontSize = 16.sp)
            }

            if (onBoardModel.description.isEmpty()){
                //If there is no description, the Indicator area should be visible
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    //Generate indicator based on the number of pages
                    repeat(pagerState.pageCount) { index ->
                        //Determine the selected one based on the current page
                        //pagerState.currentPage : Returns the current page index number
                        val isSelected = pagerState.currentPage == index
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .width(if (isSelected) 8.dp else 4.dp)
                                .height(if (isSelected) 8.dp else 4.dp)
                                .background(
                                    color = if (isSelected) Black else LightGray,
                                    shape = CircleShape
                                )
                        )
                    }
                }
            }else{
                Text(text = onBoardModel.description,
                    style = TextStyle(
                        fontSize = 11.sp,
                        color = LightGreen,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}

