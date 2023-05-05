package com.example.easypay.presentation.paymentScreen.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easypay.domain.useCases.ValidateCardCVC
import com.example.easypay.domain.useCases.ValidateCardDate
import com.example.easypay.domain.useCases.ValidateCardNum
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CardDetailsViewModel(
    private val validateCardNum: ValidateCardNum = ValidateCardNum(),
    private val validateCardCVC: ValidateCardCVC = ValidateCardCVC(),
    private val validateDate: ValidateCardDate = ValidateCardDate()
) : ViewModel() {

    var state by mutableStateOf(CardDetailsState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onCardNumberInputChanged(input: String) {
        state = state.copy(inputCardNumber = input)
    }

    fun onCardDateInputChanged(input: String) {
        state = state.copy(inputCardDate = input)
    }

    fun onCVCInputChanged(input: String) {
        state = state.copy(inputCVC = input)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submitData() {
        val cardNumValidationResult = validateCardNum.execute(state.inputCardNumber)
        val cardDateValidationResult = validateDate.execute(state.inputCardDate)
        val carCVCValidationResult = validateCardCVC.execute(state.inputCVC)
        state = state.copy(
            errorMessageCardNumber = cardNumValidationResult.errorMessage,
            errorMessageCardDate = cardDateValidationResult.errorMessage,
            errorMessageCVC = carCVCValidationResult.errorMessage
        )
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


