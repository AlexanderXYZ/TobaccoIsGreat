package com.buslaev.tobaccoisgreat.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buslaev.tobaccoisgreat.presentation.ui.main.MainScreen
import com.buslaev.tobaccoisgreat.presentation.ui.new_mix.NewMixScreen
import com.buslaev.tobaccoisgreat.presentation.ui.new_tobacco.NewTobaccoScreen
import com.buslaev.tobaccoisgreat.presentation.ui.new_tobacco.NewTobaccoViewModel
import com.buslaev.tobaccoisgreat.presentation.ui.onboarding.OnboardingScreen

enum class Screens(val route: String) {
    MAIN_SCREEN("main_screen"),
    NEW_TOBACCO("new_tobacco_screen"),
    NEW_MIX("new_mix_screen"),
    ONBOARDING("onboarding_screen")
}

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.ONBOARDING.route) {

        composable(
            route = Screens.ONBOARDING.route
        ) {
            OnboardingScreen(
                startClick = { navController.navigate(Screens.MAIN_SCREEN.route) }
            )
        }

        composable(
            route = Screens.MAIN_SCREEN.route
        ) {
            MainScreen(navController)
        }

        composable(
            route = Screens.NEW_TOBACCO.route
        ) {
            val viewModel = hiltViewModel<NewTobaccoViewModel>()
            val state = viewModel.state.collectAsState()
            NewTobaccoScreen(
                state = state.value,
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