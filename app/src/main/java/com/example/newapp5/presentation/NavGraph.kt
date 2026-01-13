package com.example.newapp5.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.tooling.ComposeToolingApi
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun  NavGraph (
    navController: NavHostController
) {
    NavHost(
        startDestination = "list",
        navController =  navController
    ) {
        composable ("list"){ ListScreen()  }
        composable ("detail"){ DetailScreen() }
    }
}