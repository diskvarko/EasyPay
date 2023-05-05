package com.example.easypay.presentation.paymentScreen.card

data class CardDetailsState(
    val inputCardNumber: String =  "",
    val errorMessageCardNumber: String? = null,
    val inputCardDate: String =  "",
    val errorMessageCardDate: String? = null,
    val inputCVC: String =  "",
    val errorMessageCVC: String? = null
)