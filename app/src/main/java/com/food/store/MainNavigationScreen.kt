package com.food.store

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.food.store.presentation.components.CustomToolBar
import com.food.store.presentation.navigation.bottomnavbar.BottomNavigationBar
import com.food.store.presentation.navigation.bottomnavbar.NavigationGraph
import com.food.store.presentation.navigation.bottomnavbar.Route
import com.food.store.presentation.navigation.bottomnavbar.bottomBarItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@Composable
fun MainNavigationScreen() {

    val navBottomItems = bottomBarItems
    val navController = rememberNavController()
    val backStackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    selectedItem = when (backStackState?.destination?.route) {
        Route.HomeScreen.screen -> 0
        Route.SearchScreen.screen -> 1
        Route.CartScreen.screen -> 2
        Route.ProfileScreen.screen -> 3
        else -> 0
    }

    val isBottomBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Route.HomeScreen.screen
                || backStackState?.destination?.route == Route.SearchScreen.screen
                || backStackState?.destination?.route == Route.CartScreen.screen
                || backStackState?.destination?.route == Route.ProfileScreen.screen
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            CustomToolBar()
        },
        bottomBar = {
            BottomNavigationBar(
                navItems = navBottomItems,
                selectedItem = selectedItem,
                onClickItem = { index ->
                    when (index) {
                        0 -> navigateToTab(
                            navController = navController,
                            route = Route.HomeScreen.screen
                        )

                        1 -> navigateToTab(
                            navController = navController,
                            route = Route.SearchScreen.screen
                        )

                        2 -> navigateToTab(
                            navController = navController,
                            route = Route.CartScreen.screen
                        )

                        3 -> navigateToTab(
                            navController = navController,
                            route = Route.ProfileScreen.screen
                        )
                    }
                }
            )
        }
    ) { innerPaddingValues ->
        NavigationGraph(navController = navController, contentPaddingValues = innerPaddingValues)
    }

}

@Composable
fun OnBackClickStateSaver(navController: NavController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Route.HomeScreen.screen
        )
    }
}

private fun navigateToTab(navController: NavController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screenRoute ->
                navController.popBackStack(route = screenRoute, inclusive = true)
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun navigateToDetails(navController: NavController) {
    //   navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Route.OnBoardingScreen.screen
    )
}

@Preview
@Composable
fun MainScreenPreview() {
    MainNavigationScreen()
}