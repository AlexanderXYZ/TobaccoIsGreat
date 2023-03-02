package com.buslaev.tobaccoisgreat.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buslaev.tobaccoisgreat.presentation.ui.main.MainScreen
import com.buslaev.tobaccoisgreat.presentation.ui.new_mix.NewMixScreen
import com.buslaev.tobaccoisgreat.presentation.ui.new_tobacco.NewTobaccoScreen

enum class Screens(val route: String) {
    MAIN_SCREEN("main_screen"),
    NEW_TOBACCO("new_tobacco_screen"),
    NEW_MIX("new_mix_screen")
}

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.MAIN_SCREEN.route) {
        composable(
            route = Screens.MAIN_SCREEN.route
        ) {
            MainScreen(navController)
        }

        composable(
            route = Screens.NEW_TOBACCO.route
        ) {
            NewTobaccoScreen(
                navController = navController
            )
        }

        composable(
            route = Screens.NEW_MIX.route
        ) {
            NewMixScreen()
        }
    }
}