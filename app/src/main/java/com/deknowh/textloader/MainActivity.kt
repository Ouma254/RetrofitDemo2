package com.deknowh.textloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.deknowh.textloader.composable.FruitScreen
import com.deknowh.textloader.ui.theme.TextLoaderTheme
import com.deknowh.textloader.viewmodel.FruitViewModel

class MainActivity : ComponentActivity() {
    // object
    private val viewModel : FruitViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextLoaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     FruitScreen(fruitViewModel = viewModel)
                }
            }
        }
    }
}
