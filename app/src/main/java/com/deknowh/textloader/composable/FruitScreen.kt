package com.deknowh.textloader.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.deknowh.textloader.viewmodel.FruitViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitScreen(fruitViewModel: FruitViewModel) {
    // loading state of the text
    val fruit by fruitViewModel.fruitData.collectAsState()


    LaunchedEffect(Unit) {
        fruitViewModel.fetchFruits()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Fruits")
                }
            )
        }
    ) {paddingValue ->
        Column(modifier = Modifier.padding(paddingValue)) {
            if (fruit.isEmpty()) {
                LoadingIndicator()
            } else {
                // show the test
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                ) {
                    LazyColumn {
                        items(fruit) {fru->
                            Card(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(80.dp)
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = fru.author,
                                    color = Color.Cyan,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold,
                                    fontStyle = FontStyle.Italic
                                )
                            }

                        }
                    }
                }
            }
        }
    }

}

// loading indicator

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            CircularProgressIndicator(
                color = Color.Red,
                modifier = Modifier
                    .padding(16.dp)
             )
    }
}