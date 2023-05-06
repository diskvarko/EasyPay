package com.example.easypay.presentation.paymentScreen.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easypay.domain.useCases.ValidateCardCVC
import com.example.easypay.domain.useCases.ValidateCardDate
import com.example.easypay.domain.useCases.ValidateCardNum
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CardDetailsViewModel(
    private val validateCardNum: ValidateCardNum = ValidateCardNum(),
    private val validateCardCVC: ValidateCardCVC = ValidateCardCVC(),
    private val validateDate: ValidateCardDate = ValidateCardDate()
) : ViewModel() {

    private val _uiState = MutableStateFlow(CardDetailsState())
    val uiState: StateFlow<CardDetailsState> = _uiState.asStateFlow()

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onCardNumberInputChanged(input: String) {
        _uiState.update { value ->
            value.copy(inputCardNumber = input)
        }
    }

    fun onCardDateInputChanged(input: String) {
        _uiState.update { value ->
            value.copy(inputCardDate = input)
        }

    }

    fun onCVCInputChanged(input: String) {
        _uiState.update { value ->
            value.copy(inputCVC = input)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submitData() {
        val cardNumValidationResult = validateCardNum.execute(uiState.value.inputCardNumber)
        val cardDateValidationResult = validateDate.execute(uiState.value.inputCardDate)
        val carCVCValidationResult = validateCardCVC.execute(uiState.value.inputCVC)
        _uiState.update { value ->
            value.copy(
                errorMessageCardNumber = cardNumValidationResult.errorMessage,
                errorMessageCardDate = cardDateValidationResult.errorMessage,
                errorMessageCVC = carCVCValidationResult.errorMessage
            )
        }
        val isError = listOf(
            cardDateValidationResult, carCVCValidationResult, cardNumValidationResult
        ).any { !it.successful }
        if (isError) {
            return
        }
        viewModelScope.launch {
            delay(1000)
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}


