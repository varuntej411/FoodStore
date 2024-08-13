package com.food.store.presentation.navigation.bottomnavbar

sealed class Route(val screen: String) {
    data object SplashScreen: Route(screen = "splash")
    data object OnBoardingScreen: Route(screen = "onboarding")
    data object MainScreenNavigation: Route(screen = "main screen")
    data object HomeScreen: Route(screen = "home")
    data object SearchScreen: Route(screen = "search")
    data object CartScreen: Route(screen = "cart")
    data object ProfileScreen: Route(screen = "profile")
}