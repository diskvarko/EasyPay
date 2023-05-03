package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.example.easypay.HomeScreen

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
    navigate(homeScreenRoute)
}