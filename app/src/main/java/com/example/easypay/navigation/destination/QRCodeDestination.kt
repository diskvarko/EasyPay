package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.example.easypay.presentation.ORCodeScanningScreen
import com.google.accompanist.navigation.animation.composable

private const val qrScreenRoute = "qrCode"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.qrCodeDestinationScreen() {
    composable(qrScreenRoute) {
        ORCodeScanningScreen()
    }
}

fun NavHostController.navigateToQRCodeScreen() {
    navigate(qrScreenRoute)
}