package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.example.easypay.ResultScreen
import com.example.easypay.ScanCardScreen

private const val resultScreenRoute = "result"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.resultScreen(onFinishClick: () -> Unit) {
    composable(route = resultScreenRoute) {
        ResultScreen {
            onFinishClick
        }
    }
}

fun NavHostController.navigateToResultScreen() {
    navigate(resultScreenRoute)
}