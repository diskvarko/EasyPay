package com.example.easypay.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.easypay.navigation.destination.*
import com.google.accompanist.navigation.animation.AnimatedNavHost


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = homeScreenRoute,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    ) {
        homeScreen {
            navController.navigateToAmountScreen()
        }
        amountScreen { amount ->
            navController.navigateToPaymentMethodScreen(amount)
        }
        chooseMethodScreen(
            onCardPaymentClick = { paymentMethod, amount ->
                navController.navigateToCardPaymentScreen(
                    paymentMethod = paymentMethod,
                    amount = amount
                )
            },
            onQRCodeClick = { paymentMethod, amount ->
                navController.navigateToQRCodeScreen(paymentMethod, amount)
            },
            onCardDetailsClick = { paymentMethod, amount ->
                navController.navigateToCardDataPaymentScreen(paymentMethod, amount)
            })
        cardPaymentScreen(onResultGo = { amount, paymentMethod ->
            navController.navigateToResultScreen(
                paymentMethod = paymentMethod,
                amount = amount,
                cardNum = null,
            )
        })
        qrCodeDestinationScreen(onResultGo = { amount, paymentMethod ->
            navController.navigateToResultScreen(paymentMethod = paymentMethod, amount = amount, cardNum = null)
        })
        cardDataPaymentScreen(onNextClick = { amount, paymentMethod, cardNum ->
            navController.navigateToResultScreen(
                paymentMethod = paymentMethod,
                amount = amount,
                cardNum = cardNum
            )
        })
        resultScreen {
            navController.popBackStack(route = homeScreenRoute, inclusive = false)
        }
    }
}