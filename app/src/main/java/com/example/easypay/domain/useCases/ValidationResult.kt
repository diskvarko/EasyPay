package com.example.easypay.domain.useCases

data class ValidationResult (
    val successful: Boolean,
    val errorMessage: String? = null
)