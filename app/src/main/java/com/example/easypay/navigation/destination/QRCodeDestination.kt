package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.easypay.presentation.paymentScreen.ORCodeScanningScreen
import com.google.accompanist.navigation.animation.composable

private const val qrScreenRoute = "qrCode"
private const val paymentMethodKey = "paymentMethod"
private const val amountKey = "amount"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.qrCodeDestinationScreen(onResultGo: (amount: String, paymentMethod: String) -> Unit) {
    composable(route = qrScreenRoute,
        arguments = listOf(
            navArgument(paymentMethodKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            },
            navArgument(amountKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )) { backStackEntry ->
        val amount = backStackEntry.savedStateHandle.get<String>(amountKey).orEmpty()
        val paymentMethod = backStackEntry.savedStateHandle.get<String>(paymentMethodKey).orEmpty()
        ORCodeScanningScreen(
            amount = amount,
            paymentMethod = paymentMethod,
            onResultGo = onResultGo
        )
    }
}

fun NavHostController.navigateToQRCodeScreen(paymentMethod: String, amount: String) {
    navigate(qrScreenRoute)
    currentBackStackEntry?.let {
        it.savedStateHandle[paymentMethodKey] = paymentMethod
        it.savedStateHandle[amountKey] = amount
    }
}