package com.example.easypay.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easypay.R
import com.example.easypay.ui.theme.BlueLight
import com.example.easypay.ui.theme.RedLight
import com.example.easypay.ui.theme.buttonStyle
import com.example.easypay.ui.theme.normalStyle

@Composable
fun ResultPaymentHeader(isSuccessful: Boolean) {
    Box(
        Modifier
            .background(
                color = if (isSuccessful) {
                    BlueLight
                } else {
                    RedLight.copy(alpha = 0.6f)
                },
                shape = RoundedCornerShape(
                    topStartPercent = 0,
                    topEndPercent = 0,
                    bottomEndPercent = 25,
                    bottomStartPercent = 25
                )
            )
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(50.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = if (isSuccessful) {
                    painterResource(id = R.drawable.success)
                } else {
                    painterResource(id = R.drawable.error)
                },
                contentDescription = null,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                text = if (isSuccessful) {
                    "Your payment was successful!"
                } else {
                    "Your payment failed!"
                },
                style = MaterialTheme.typography.buttonStyle,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                maxLines = 2,
                color = Color.White
            )
        }
    }
}

@Composable
fun ResultScreen(onFinishClick: () -> Unit) {
    Column() {
        ResultPaymentHeader(true)
        Text(
            text = "Payment details",
            style = MaterialTheme.typography.normalStyle,
            fontSize = 20.sp,
            color = Color.Black.copy(alpha = 0.7f),
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp)
        )
        LazyColumn(Modifier.padding(horizontal = 20.dp)) {
            repeat(4) {
                item() {
                    TwoLinesText(
                        modifier = Modifier,
                        headerText = "11",
                        descriptionText = "121"
                    )
                }
            }
        }
        ButtonActive(
            text = "Finish",
            action = onFinishClick
        )
    }
}

@Preview
@Composable
fun ResultPaymentPreview() {
        ResultScreen {}
}
