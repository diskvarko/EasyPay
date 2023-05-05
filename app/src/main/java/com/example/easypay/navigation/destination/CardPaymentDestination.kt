package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.easypay.presentation.paymentScreen.ScanCardScreen
import com.google.accompanist.navigation.animation.composable

private const val cardPaymentScreenRoute = "cardPayment"
private const val paymentMethodKey = "paymentMethod"
private const val amountKey = "amount"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.cardPaymentScreen(
    onResultGo: (amount: String, paymentMethod: String) -> Unit
) {
    composable(route = cardPaymentScreenRoute,
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
        ScanCardScreen(
            amount = amount,
            paymentMethod = paymentMethod,
            onResultGo = onResultGo
        )
    }
}

fun NavHostController.navigateToCardPaymentScreen(paymentMethod: String, amount: String) {
    navigate(cardPaymentScreenRoute)
    currentBackStackEntry?.let {
        it.savedStateHandle[paymentMethodKey] = paymentMethod
        it.savedStateHandle[amountKey] = amount
    }
}