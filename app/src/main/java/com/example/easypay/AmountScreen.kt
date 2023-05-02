package com.example.easypay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easypay.ui.theme.BlueLight
import com.example.easypay.ui.theme.lightStyle2

@Composable
fun AmountScreen() {
    Column(Modifier.fillMaxSize()) {
        Column(Modifier.weight(2f)) {
            HeaderText(
                text = "Enter amount",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 50.dp)
            )
            InputField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
                text = "",
                onValueChange = {}
            )
            InfoBox(Modifier.padding(20.dp))
        }
        ButtonActive(text = "Next", modifier = Modifier.padding(vertical = 50.dp)) {

        }
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

@Preview
@Composable
fun AmountScreenPreview() {
    Surface {
        AmountScreen()
    }
}