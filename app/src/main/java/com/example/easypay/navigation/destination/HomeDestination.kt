package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.easypay.presentation.homeScreen.HomeScreen
import com.google.accompanist.navigation.animation.composable

const val homeScreenRoute = "home"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(createPaymentClick: () -> Unit) {
    composable(homeScreenRoute) {
        HomeScreen(
            createPaymentClick = createPaymentClick
        )
    }
}

fun NavHostController.navigateToHomeScreen() {
    navigate(homeScreenRoute) {
        launchSingleTop
    }
}