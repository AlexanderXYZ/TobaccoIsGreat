package com.buslaev.tobaccoisgreat.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.buslaev.tobaccoisgreat.presentation.theme.TobaccoIsGreatTheme

@Composable
fun App() {
    val navController = rememberNavController()

    TobaccoIsGreatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavGraph(
                navController = navController
            )
        }
    }
}