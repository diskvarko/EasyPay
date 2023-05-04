package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.easypay.presentation.ResultScreen
import com.google.accompanist.navigation.animation.composable

private const val resultScreenRoute = "result"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.resultScreen(onFinishClick: () -> Unit) {
    composable(route = resultScreenRoute) {
        ResultScreen {
            onFinishClick.invoke()
        }
    }
}

fun NavHostController.navigateToResultScreen() {
    navigate(resultScreenRoute)
}