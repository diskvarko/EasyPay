package com.example.easypay

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
import com.example.easypay.ui.theme.GrayLight
import com.example.easypay.ui.theme.lightStyle1
import com.example.easypay.ui.theme.lightStyle2

@Composable
fun ORCodeScanningScreen() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.qr_scan),
            contentDescription = null
        )
        Text(
            text = "QR code scanning",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp),
            fontSize = 25.sp,
            style = MaterialTheme.typography.lightStyle1,
            color = Color.Black
        )
        Text(
            text = "Put the QR code to be scanned into\nthe frame",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            style = MaterialTheme.typography.lightStyle2,
            color = GrayLight,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ORCodeScanningScreenPreview() {
    Surface() {
        ORCodeScanningScreen()
    }

}