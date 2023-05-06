package com.example.easypay.presentation.amountScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easypay.domain.useCases.ValidateAmount
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class AmountScreenViewModel(
    private val validateAmount: ValidateAmount = ValidateAmount()
) : ViewModel() {

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(AmountFormState())
    val uiState: StateFlow<AmountFormState> = _uiState.asStateFlow()

    fun onAmountInputChanged(input: String) {
        viewModelScope.launch {
            _uiState.update { value ->
                value.copy(input = input)
            }
        }
    }

    fun submitAmount() {
        val amount = uiState.value.input
        val amountValidationResult = validateAmount.execute(uiState.value.input, 10, 10000)
        _uiState.update { value ->
            value.copy(errorMessage = amountValidationResult.errorMessage)
        }
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


