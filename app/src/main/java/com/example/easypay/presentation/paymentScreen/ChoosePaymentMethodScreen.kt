package com.example.easypay.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChoosePaymentMethodScreen(
    onCardPaymentClick: () -> Unit,
    onQRClick: () -> Unit,
    onCardDetailsClick: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        HeaderText(
            text = "Choose payment method",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 50.dp)
        )
        ButtonActive(
            text = "Card payment",
            modifier = Modifier.padding(vertical = 20.dp),
            action = onCardPaymentClick
        )
        ButtonActive(
            text = "QR-code",
            modifier = Modifier.padding(vertical = 20.dp),
            action = onQRClick
        )
        ButtonActive(
            text = "Card details",
            modifier = Modifier.padding(vertical = 20.dp),
            action = onCardDetailsClick
        )
    }
}

@Preview
@Composable
fun ChoosePaymentMethodScreenPreview() {
    Surface() {
        ChoosePaymentMethodScreen({}, {}, {})
    }
}