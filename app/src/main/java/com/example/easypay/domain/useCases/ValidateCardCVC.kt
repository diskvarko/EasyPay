package com.example.easypay.domain.useCases

class ValidateCardCVC {
    fun execute(cvcCode: String): ValidationResult {
        if (cvcCode.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "CVC can't be empty"
            )
        } else if (cvcCode.length != 3) {
            return ValidationResult(
                successful = false,
                errorMessage = "invalid CVC"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}