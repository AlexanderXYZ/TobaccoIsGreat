package com.buslaev.tobaccoisgreat.presentation.ui.main

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.buslaev.tobaccoisgreat.presentation.ui.main.mix.MixScreen
import com.buslaev.tobaccoisgreat.presentation.ui.main.tobacco.TobaccoScreen

enum class BottomScreens(val label: String, val route: String) {
    TOBACCO_SCREEN(
        label = "Tobacco",
        route = "tobacco_screen"
    ),
    MIX_SCREEN(
        label = "Mixes",
        route = "mix_screen"
    ),
}

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomScreens.TOBACCO_SCREEN.route,
        modifier = modifier
    ) {
        composable(BottomScreens.TOBACCO_SCREEN.route) {
            TobaccoScreen()
        }
        composable(BottomScreens.MIX_SCREEN.route) {
            MixScreen()
        }
    }
}

@Composable
fun MainBottomNavigationBar(
    navController: NavHostController
) {
    NavigationBar {
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