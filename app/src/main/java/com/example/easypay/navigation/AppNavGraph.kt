package com.example.easypay.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.easypay.navigation.destination.amountScreen
import com.example.easypay.navigation.destination.cardPaymentScreen
import com.example.easypay.navigation.destination.chooseMethodScreen
import com.example.easypay.navigation.destination.homeScreen
import com.example.easypay.navigation.destination.homeScreenRoute
import com.example.easypay.navigation.destination.navigateToAmountScreen
import com.example.easypay.navigation.destination.navigateToCardPaymentScreen
import com.example.easypay.navigation.destination.navigateToHomeScreen
import com.example.easypay.navigation.destination.navigateToPaymentMethodScreen
import com.example.easypay.navigation.destination.navigateToQRCodeScreen
import com.example.easypay.navigation.destination.qrCodeDestinationScreen
import com.example.easypay.navigation.destination.resultScreen
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
        amountScreen {
            navController.navigateToPaymentMethodScreen()
        }
        chooseMethodScreen(
            onCardPaymentClick = {
                navController.navigateToCardPaymentScreen()
            },
            onQRCodeClick = {
                navController.navigateToQRCodeScreen()
            },
            onCardDetailsClick = {

            })
        cardPaymentScreen()
        qrCodeDestinationScreen()
        resultScreen {
            navController.popBackStack()
        }
    }
}