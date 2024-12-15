package com.example.hubxapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hubxapp.R
import com.example.hubxapp.ui.theme.Black
import com.example.hubxapp.ui.theme.LightGray
import com.example.hubxapp.ui.viewmodel.HomeScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderSection(homeScreenViewModel: HomeScreenViewModel){
    val searchCategories = rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .height(165.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.plant),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.headerText1),
                modifier = Modifier.padding(bottom = 4.dp),
                color = Black,
                fontSize = 18.sp
            )
            Text(
                text = stringResource(id = R.string.headerText2),
                modifier = Modifier.padding(bottom = 16.dp),
                color = Black,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            OutlinedTextField(
                value = searchCategories.value,
                onValueChange = { searchQuery ->
                    searchCategories.value = searchQuery
                    homeScreenViewModel.searchCategories(searchQuery)
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(id = R.string.searchText))},
                singleLine = true,
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier.size(16.dp),
                        tint = LightGray

                    )
                },
                keyboardActions = KeyboardActions(
                    onDone = {
                        // Arama işlemine tıklandığında yapılacak işlem!!
                    }
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    containerColor = Color.White,
                    focusedTextColor = Black,
                    unfocusedTextColor = Black,
                    focusedLabelColor = Black,
                    unfocusedLabelColor = LightGray,
                ),
                shape = MaterialTheme.shapes.medium
            )
        }
    }
}