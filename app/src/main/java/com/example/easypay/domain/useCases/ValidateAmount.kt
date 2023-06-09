package com.example.easypay.domain.useCases

class ValidateAmount {
    fun execute(amount: String, minValue: Int, maxValue: Int): ValidationResult {
        if (amount.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Empty field"
            )
        } else if (amount.toInt() !in minValue..maxValue) {
            return ValidationResult(
                successful = false,
                errorMessage = "Value is out of range"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}