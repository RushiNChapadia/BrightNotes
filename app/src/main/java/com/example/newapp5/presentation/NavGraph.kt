package com.example.newapp5.presentation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.tooling.ComposeToolingApi
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        startDestination = "list",
        navController = navController
    ) {
        composable("list") {
            ListScreen(
                onItemClick = {
                    Log.d("TAG", "NavGraph: Click event from child")
                    navController.navigate("details")
                }
            )
        }
        composable("details") { DetailScreen() }
    }
}