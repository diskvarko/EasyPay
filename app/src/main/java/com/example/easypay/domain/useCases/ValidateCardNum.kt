package com.example.easypay.domain.useCases

class ValidateCardNum {

    fun execute(cardNumber: String): ValidationResult {
        if (cardNumber.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Card number can't be empty"
            )
        } else if (cardNumber.length != 16) {
            return ValidationResult(
                successful = false,
                errorMessage = "invalid value"
            )
        }
        return ValidationResult(
            successful = true
        )
    }

}