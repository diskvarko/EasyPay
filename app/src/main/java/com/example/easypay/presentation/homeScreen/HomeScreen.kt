package com.example.easypay.presentation.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easypay.R
import com.example.easypay.presentation.common.ButtonActive
import com.example.easypay.ui.theme.headerStyle
import com.example.easypay.ui.theme.lightStyle1

@Composable
fun HomeScreen(createPaymentClick: () -> Unit) {
    Column {
        StartScreen(
            Modifier
                .weight(2f)
                .padding(vertical = 70.dp)
        )
        ButtonActive(text = "New payment", action = createPaymentClick)
    }
}

@Composable
fun StartScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.scanning),
            contentDescription = null
        )
        Text(
            text = "EASY POS",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp),
            fontSize = 35.sp,
            style = MaterialTheme.typography.headerStyle
        )
        Text(
            text = "Welcome back, Diana",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            style = MaterialTheme.typography.lightStyle1
        )
    }
}

