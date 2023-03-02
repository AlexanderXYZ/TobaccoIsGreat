package com.buslaev.tobaccoisgreat.presentation.ui.new_tobacco

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.buslaev.tobaccoisgreat.R
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTobaccoScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TobaccoTopAppBar(
                title = stringResource(id = R.string.new_tobacco_screen_title),
                onBackClick = navController::popBackStack
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
    }
}