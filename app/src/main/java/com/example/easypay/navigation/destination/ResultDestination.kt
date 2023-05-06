package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.easypay.presentation.resultScreen.ResultScreen
import com.google.accompanist.navigation.animation.composable

private const val resultScreenRoute = "result"
private const val cardNumKey = "cardNum"
private const val amountKey = "amount"
private const val paymentMethodKey = "paymentMethod"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.resultScreen(onFinishClick: () -> Unit) {
    composable(route = resultScreenRoute,
        arguments = listOf(
            navArgument(cardNumKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = "4255 2003 0281 4409"
            },
            navArgument(amountKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = "12"
            },
            navArgument(paymentMethodKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )
    ) { backStackEntry ->
        val cardNum = backStackEntry.savedStateHandle.get<String>(cardNumKey) ?: "4255 2003 0281 4409"
        val amount = backStackEntry.savedStateHandle.get<String>(amountKey).orEmpty()
        val paymentMethod = backStackEntry.savedStateHandle.get<String>(paymentMethodKey).orEmpty()
        val list = listOf(
            Pair("Card number", cardNum),
            Pair("Amount", amount.ifEmpty { "12" } + "$"),
            Pair("Payment method", paymentMethod),
        )
        ResultScreen(list) {
            onFinishClick.invoke()
        }
    }
}


fun NavHostController.navigateToResultScreen(
    paymentMethod: String,
    cardNum: String?,
    amount: String
) {
    navigate(resultScreenRoute)
    currentBackStackEntry?.let {
        it.savedStateHandle[paymentMethodKey] = paymentMethod
        it.savedStateHandle[amountKey] = amount
        it.savedStateHandle[cardNumKey] = cardNum
    }
}