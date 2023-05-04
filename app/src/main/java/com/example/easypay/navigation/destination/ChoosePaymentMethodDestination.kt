package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.example.easypay.presentation.ChoosePaymentMethodScreen

private const val methodScreenRoute = "method"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.chooseMethodScreen(
    onCardPaymentClick: () -> Unit,
    onQRCodeClick: () -> Unit,
    onCardDetailsClick: () -> Unit
) {
    composable("method") {
        ChoosePaymentMethodScreen(
            onCardPaymentClick = onCardPaymentClick,
            onQRClick = onQRCodeClick,
            onCardDetailsClick = onCardDetailsClick
        )
    }
}

fun NavHostController.navigateToPaymentMethodScreen() {
    navigate(methodScreenRoute)
}