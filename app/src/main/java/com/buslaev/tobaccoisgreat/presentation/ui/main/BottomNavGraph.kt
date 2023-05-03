package com.buslaev.tobaccoisgreat.presentation.ui.main

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.buslaev.tobaccoisgreat.presentation.ui.Screens
import com.buslaev.tobaccoisgreat.presentation.ui.components.TobaccoNavigationBar
import com.buslaev.tobaccoisgreat.presentation.ui.main.mix.MixScreen
import com.buslaev.tobaccoisgreat.presentation.ui.main.profile.ProfileScreen
import com.buslaev.tobaccoisgreat.presentation.ui.main.tobacco.TobaccoScreen
import com.buslaev.tobaccoisgreat.presentation.ui.main.tobacco.TobaccoViewModel

enum class BottomScreens(val label: String, val route: String) {
    TOBACCO_SCREEN(
        label = "Tobacco",
        route = "tobacco_screen"
    ),
    MIX_SCREEN(
        label = "Mixes",
        route = "mix_screen"
    ),
    PROFILE_SCREEN(
        label = "Profile",
        route = "profile_sreen"
    )
}

@Composable
fun BottomNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    navigateToScreen: (Screens) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomScreens.TOBACCO_SCREEN.route,
        modifier = modifier
    ) {
        composable(route = BottomScreens.TOBACCO_SCREEN.route) {
            val viewModel = hiltViewModel<TobaccoViewModel>()
            val state = viewModel.state.collectAsState()
            TobaccoScreen(
                state = state.value,
                navigateToAddTobaccoScreen = { navigateToScreen.invoke(Screens.NEW_TOBACCO) }
            )
        }
        composable(route = BottomScreens.MIX_SCREEN.route) {
            MixScreen()
        }
        composable(route = BottomScreens.PROFILE_SCREEN.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun MainBottomNavigationBar(
    navController: NavHostController
) {
    TobaccoNavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomScreens.values().forEach { screen ->
            NavigationBarItem(
                icon = {},
                label = { Text(text = screen.label) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}