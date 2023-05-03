@file:JvmName("AmountDestinationKt")

package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.easypay.AmountScreen
import com.google.accompanist.navigation.animation.composable

private const val amountScreenRoute = "amount"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.amountScreen(onNextClick: () -> Unit) {
    composable(amountScreenRoute) {
        AmountScreen(
            onNextClick = onNextClick
        )
    }
}

fun NavHostController.navigateToAmountScreen() {
    navigate(amountScreenRoute)
}