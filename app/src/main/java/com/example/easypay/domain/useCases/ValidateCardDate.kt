package com.example.easypay.domain.useCases

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*

class ValidateCardDate {
    @RequiresApi(Build.VERSION_CODES.O)
    fun execute(date: String): ValidationResult {
        if (date.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Date can't be empty"
            )
        }
        val month = date.substring(0, 2).toInt()
        val year = date.substring(2, 4).toInt()
        val currDate = LocalDateTime.now()
        val currentYear = currDate.year.toString().substring(2,4).toInt()
        val currentMonth = currDate.month.value
        if (!(year >= currentYear && month >= currentMonth && month <= 12)) {
            return ValidationResult(
                successful = false,
                errorMessage = "Card expired"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}