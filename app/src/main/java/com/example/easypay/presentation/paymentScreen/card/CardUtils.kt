package com.example.easypay.presentation.paymentScreen.card

import com.example.easypay.R
import com.example.easypay.data.CardType
import com.example.easypay.data.getCardTypeFromNumber

fun getCardTypeIcon(number: String): Int {
    val iconRes = when (getCardTypeFromNumber(number)) {
        CardType.VISA -> R.drawable.visa
        CardType.MASTERCARD -> R.drawable.mastercard
        CardType.AMERICAN_EXPRESS -> R.drawable.american_express
        CardType.MAESTRO -> R.drawable.maestro
        CardType.DINNERS_CLUB -> R.drawable.dinners_club
        CardType.DISCOVER -> R.drawable.discover
        CardType.JCB -> R.drawable.jcb
        else -> R.drawable.visa
    }
    return iconRes
}