package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.example.easypay.ScanCardScreen

private const val cardPaymentScreenRoute = "cardPayment"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.cardPaymentScreen() {
    composable(cardPaymentScreenRoute) {
        ScanCardScreen()
    }
}

fun NavHostController.navigateToCardPaymentScreen() {
    navigate(cardPaymentScreenRoute)
}