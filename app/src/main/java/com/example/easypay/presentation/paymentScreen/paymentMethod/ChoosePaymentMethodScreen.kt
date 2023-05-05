package com.example.easypay.presentation.paymentScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.easypay.presentation.common.ButtonActive
import com.example.easypay.presentation.common.HeaderText

@Composable
fun ChoosePaymentMethodScreen(
    amount: String,
    onCardPaymentClick: (paymentMethod: String, amount: String) -> Unit,
    onQRClick: (paymentMethod: String, amount: String) -> Unit,
    onCardDetailsClick: (paymentMethod: String, amount: String) -> Unit
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
            action = { onCardPaymentClick("Card", amount) }
        )
        ButtonActive(
            text = "QR-code",
            modifier = Modifier.padding(vertical = 20.dp),
            action = { onQRClick("QR-code", amount) }
        )
        ButtonActive(
            text = "Card details",
            modifier = Modifier.padding(vertical = 20.dp),
            action = { onCardDetailsClick("Card data", amount) }
        )
    }
}
