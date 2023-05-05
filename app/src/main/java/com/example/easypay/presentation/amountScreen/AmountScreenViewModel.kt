package com.example.easypay.presentation.amountScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easypay.domain.useCases.ValidateAmount
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AmountScreenViewModel(
    private val validateAmount: ValidateAmount = ValidateAmount()
) : ViewModel() {

    var state by mutableStateOf(AmountFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onAmountInputChanged(input: String) {
        state = state.copy(input = input)
    }

    fun submitAmount() {
        val amountValidationResult = validateAmount.execute(state.input, 10, 10000)
        state = state.copy(
            errorMessage = amountValidationResult.errorMessage
        )
        val isError = !amountValidationResult.successful
        if (isError) {
            return
        }
        viewModelScope.launch {
            delay(500)
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}


