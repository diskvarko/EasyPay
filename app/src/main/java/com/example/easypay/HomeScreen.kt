package com.example.easypay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easypay.ui.theme.*

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    EasyPayTheme {
            HomeScreen({})
    }
}

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

