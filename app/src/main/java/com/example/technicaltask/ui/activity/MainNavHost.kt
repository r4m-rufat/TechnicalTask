package com.example.technicaltask.ui.activity

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.technicaltask.ui.activity.country.CountryScreen
import com.example.technicaltask.ui.activity.favorite.FavoritesScreen

@Composable
fun MainNavHost(
    context: Context,
    navHostController: NavHostController,
    viewModel: MainViewModel
) {

    NavHost(
        navController = navHostController,
        startDestination = MainNavHost.HomeScreen
    ) {

        composable(route = MainNavHost.HomeScreen) {
            CountryScreen(
                navHostController = navHostController,
                viewModel = viewModel
            )
        }

        composable(route = MainNavHost.FavoritesScreen) {
            FavoritesScreen(
                navHostController = navHostController,
                viewModel = viewModel
            )
        }
    }
}

object MainNavHost {
    const val HomeScreen = "HomeScreen"
    const val FavoritesScreen = "FavoritesScreen"
}