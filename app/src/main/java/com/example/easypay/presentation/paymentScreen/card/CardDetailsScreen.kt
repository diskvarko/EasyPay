package com.example.easypay.presentation.paymentScreen.card

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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
import com.example.easypay.ui.theme.Shapes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CardDetailsScreen(
    paymentMethod: String,
    amount: String,
    bottomSheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
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
                .padding(top = 10.dp, end = 20.dp, start = 20.dp),
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
                Image(
                    painter = painterResource(id = getCardTypeIcon(state.inputCardNumber)),
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
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                coroutineScope.launch {
                                    bottomSheetState.show()
                                }
                            }
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


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetScreen(
    paymentMethod: String,
    amount: String,
    onNextClick: (amount: String, paymentMethod: String, cardNum: String) -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        sheetContent = {
            BottomSheetContent(modifier = Modifier)
        }) {
        CardDetailsScreen(
            paymentMethod = paymentMethod,
            amount = amount,
            bottomSheetState = sheetState,
            coroutineScope = scope,
            onNextClick = onNextClick
        )
    }
}

