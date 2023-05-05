package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.easypay.presentation.paymentScreen.ChoosePaymentMethodScreen
import com.google.accompanist.navigation.animation.composable

private const val methodScreenRoute = "method"
private const val amountKey = "amount"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.chooseMethodScreen(
    onCardPaymentClick: (paymentMethod: String, amount: String) -> Unit,
    onQRCodeClick: (paymentMethod: String, amount: String) -> Unit,
    onCardDetailsClick: (paymentMethod: String, amount: String) -> Unit
) {
    composable(
        route = methodScreenRoute,
        arguments = listOf(
            navArgument(amountKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })
    ) { backStackEntry ->
        val amount = backStackEntry.savedStateHandle.get<String>(amountKey).orEmpty()
        ChoosePaymentMethodScreen(
            amount = amount,
            onCardPaymentClick = onCardPaymentClick,
            onQRClick = onQRCodeClick,
            onCardDetailsClick = onCardDetailsClick
        )
    }
}

fun NavHostController.navigateToPaymentMethodScreen(amount: String) {
    navigate(methodScreenRoute)
    currentBackStackEntry?.let {
        it.savedStateHandle[amountKey] = amount
    }
}