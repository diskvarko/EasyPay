package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.easypay.presentation.paymentScreen.card.CardDetailsScreen
import com.google.accompanist.navigation.animation.composable

private const val cardDataPaymentScreenRoute = "cardDataPayment"
private const val paymentMethodKey = "paymentMethod"
private const val amountKey = "amount"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.cardDataPaymentScreen(onNextClick: (amount: String, paymentMethod: String, cardNum: String) -> Unit) {
    composable(cardDataPaymentScreenRoute,
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
        CardDetailsScreen(
            amount = amount,
            paymentMethod = paymentMethod,
            onNextClick = onNextClick
        )
    }
}

fun NavHostController.navigateToCardDataPaymentScreen(paymentMethod: String, amount: String) {
    navigate(cardDataPaymentScreenRoute)
    currentBackStackEntry?.let {
        it.savedStateHandle[paymentMethodKey] = paymentMethod
        it.savedStateHandle[amountKey] = amount
    }
}