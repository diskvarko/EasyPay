package com.example.easypay.presentation.amountScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.easypay.presentation.common.ButtonActive
import com.example.easypay.presentation.common.HeaderText
import com.example.easypay.presentation.common.InputField
import com.example.easypay.ui.theme.BlueLight
import com.example.easypay.ui.theme.lightStyle2

@Composable
fun AmountScreen(
    onNextClick: (String) -> Unit
) {
    val viewModel = viewModel<AmountScreenViewModel>()
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is AmountScreenViewModel.ValidationEvent.Success -> onNextClick.invoke(state.input)
            }
        }
    }
    Column(Modifier.fillMaxSize()) {
        Column(Modifier.weight(2f)) {
            HeaderText(
                text = "Enter amount",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 50.dp)
            )
            InputField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                text = state.input,
                isError = state.errorMessage != null,
                placeholderText = "0.0$",
                onValueChange = {
                    viewModel.onAmountInputChanged(it)
                },
                keyboardType = KeyboardType.Number
            )
            if (state.errorMessage != null) {
                Text(
                    text = state.errorMessage!!,
                    color = Color.Red,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 30.dp)
                )
            }
            InfoBox(Modifier.padding(20.dp))
        }
        ButtonActive(
            text = "Next",
            modifier = Modifier.padding(vertical = 50.dp),
            action = {
                viewModel.submitAmount()
            }
        )
    }
}

@Composable
fun InfoBox(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(
                color = BlueLight.copy(alpha = 0.2f),
                shape = RoundedCornerShape(percent = 25)
            )
            .fillMaxWidth()
    ) {
        Text(
            text = "The maximum payment amount is \$10.000, the minimum is \$10",
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(30.dp),
            style = MaterialTheme.typography.lightStyle2,
            color = Color.Black.copy(alpha = 0.8f)
        )
    }
}
