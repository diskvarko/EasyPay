package com.example.easypay.presentation.resultScreen

data class ResultScreenModel(
    val amountName: String = "AMOUNT",
    val amountValue: String = "12",
    val cardNumberName: String = "Card number",
    val cardNumberValue: String? = "4216 5554 9876 4854",
    val paymentMethod: String = "Payment method",
    val paymentMethodValue: String = "Card",
)