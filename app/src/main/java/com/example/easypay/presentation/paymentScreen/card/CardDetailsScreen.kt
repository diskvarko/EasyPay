package com.example.easypay.presentation.paymentScreen.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.easypay.R
import com.example.easypay.data.CardNumberMask
import com.example.easypay.data.CardType
import com.example.easypay.data.ExpirationDateMask
import com.example.easypay.data.getCardTypeFromNumber
import com.example.easypay.presentation.common.ButtonActive
import com.example.easypay.presentation.common.HeaderText
import com.example.easypay.presentation.common.InputField

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CardDetailsScreen(
    paymentMethod: String,
    amount: String,
    onNextClick: (amount: String, paymentMethod: String, cardNum: String) -> Unit
) {
    val viewModel = viewModel<CardDetailsViewModel>()
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is CardDetailsViewModel.ValidationEvent.Success -> onNextClick.invoke(
                    amount,
                    paymentMethod,
                    state.inputCardNumber
                )
            }
        }
    }
    Column(Modifier.fillMaxSize()) {
        HeaderText(
            text = "Enter card data",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 50.dp)
        )
        InputField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            text = state.inputCardNumber,
            isError = state.errorMessageCardNumber != null,
            placeholderText = "1234 4567 9876 1234",
            onValueChange = {
                if (it.length <= 16) viewModel.onCardNumberInputChanged(it)
            },
            visualTransformation = CardNumberMask(" "),
            keyboardType = KeyboardType.Number,
            label = "16 digits number",
            trailingIcon = {
                val iconRes = when (getCardTypeFromNumber(state.inputCardNumber)) {
                    CardType.VISA -> R.drawable.visa
                    CardType.MASTERCARD -> R.drawable.mastercard
                    CardType.AMERICAN_EXPRESS -> R.drawable.american_express
                    CardType.MAESTRO -> R.drawable.maestro
                    CardType.DINNERS_CLUB -> R.drawable.dinners_club
                    CardType.DISCOVER -> R.drawable.discover
                    CardType.JCB -> R.drawable.jcb
                    else -> R.drawable.visa
                }
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = "card_type",
                    modifier = Modifier
                        .height(30.dp)
                        .width(40.dp)
                        .padding(end = 10.dp)
                )
            }
        )
        if (state.errorMessageCardNumber != null) {
            Text(
                text = state.errorMessageCardNumber!!,
                color = Color.Red,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 20.dp)
            )
        }
        Row(
            Modifier
                .align(Alignment.Start)
                .padding(horizontal = 20.dp)
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            ) {
                InputField(
                    modifier = Modifier,
                    text = state.inputCardDate,
                    isError = state.errorMessageCardDate != null,
                    placeholderText = "MM / YY",
                    onValueChange = {
                        if (it.length <= 4) viewModel.onCardDateInputChanged(it)
                    },
                    keyboardType = KeyboardType.Number,
                    label = "Expiration date",
                    visualTransformation = ExpirationDateMask(),
                )
                if (state.errorMessageCardDate != null) {
                    Text(
                        text = state.errorMessageCardDate!!,
                        color = Color.Red,
                        modifier = Modifier
                    )
                }
            }
            Column(
                Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            ) {
                InputField(
                    modifier = Modifier,
                    text = state.inputCVC,
                    isError = state.errorMessageCVC != null,
                    placeholderText = "***",
                    onValueChange = {
                        if (it.length <= 3) viewModel.onCVCInputChanged(it)
                    },
                    keyboardType = KeyboardType.Number,
                    label = "CVC",
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.info_icon),
                            contentDescription = null
                        )
                    }
                )
                if (state.errorMessageCVC != null) {
                    Text(
                        text = state.errorMessageCVC!!,
                        color = Color.Red,
                        modifier = Modifier
                    )
                }
            }
        }
        ButtonActive(
            text = "Next",
            modifier = Modifier.padding(vertical = 50.dp),
            action = {
                viewModel.submitData()
            }
        )
    }
}

