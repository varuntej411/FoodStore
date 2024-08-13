package com.food.store.presentation.navigation.bottomnavbar

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.food.store.presentation.screens.CartScreen
import com.food.store.presentation.screens.HomeScreen
import com.food.store.presentation.screens.ProfileScreen
import com.food.store.presentation.screens.SearchScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    contentPaddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = Route.HomeScreen.screen) {

        composable(route = Route.HomeScreen.screen) {
            HomeScreen(contentPaddingValues = contentPaddingValues)
        }
        composable(route = Route.SearchScreen.screen) {
            SearchScreen()
        }
        composable(route = Route.CartScreen.screen) {
            CartScreen()
        }
        composable(route = Route.ProfileScreen.screen) {
            ProfileScreen()
        }
    }
}
