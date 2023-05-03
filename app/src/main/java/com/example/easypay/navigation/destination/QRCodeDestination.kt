package com.example.easypay.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.example.easypay.ORCodeScanningScreen
import com.example.easypay.ScanCardScreen

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