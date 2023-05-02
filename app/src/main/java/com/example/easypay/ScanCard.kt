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
import com.example.easypay.ui.theme.lightStyle1
import com.example.easypay.ui.theme.lightStyle2

@Composable
fun ScanCardScreen() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.nfc_logo),
            contentDescription = null
        )
        Text(
            text = "Attach a card",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp),
            fontSize = 25.sp,
            style = MaterialTheme.typography.lightStyle1,
            color = Color.Black
        )
        Text(
            text = "Make sure the card\n",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            style = MaterialTheme.typography.lightStyle2,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ScanCardScreenPreview() {
    Surface() {
        ScanCardScreen()
    }

}