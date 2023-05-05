package com.example.easypay.presentation.paymentScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach

class PaymentViewModel : ViewModel() {
    val listCardAnimations =
        listOf<String>("Attach a card", "Collecting data", "Processing payment")
            .asSequence()
            .asFlow()
            .onEach {
                delay(2000)
            }
    val listQRAnimations = listOf<String>("Collecting data", "Processing payment")
        .asSequence()
        .asFlow()
        .onEach {
            delay(2000)
        }
}