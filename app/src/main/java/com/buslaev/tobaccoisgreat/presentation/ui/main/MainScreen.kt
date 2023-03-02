package com.buslaev.tobaccoisgreat.presentation.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.buslaev.tobaccoisgreat.presentation.theme.DarkGrayColor
import com.buslaev.tobaccoisgreat.presentation.ui.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val route = when (bottomNavController.currentBackStackEntry?.destination?.route) {
                    BottomScreens.TOBACCO_SCREEN.route -> Screens.NEW_TOBACCO.route
                    BottomScreens.MIX_SCREEN.route -> Screens.NEW_MIX.route
                    else -> null
                }
                route?.let { navController.navigate(it) }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },
        bottomBar = {
            MainBottomNavigationBar(bottomNavController)
        }
    ) { innerPadding ->
        BottomNavGraph(
            navController = bottomNavController,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(DarkGrayColor)
        )
    }
}