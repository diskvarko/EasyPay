package com.example.easypay.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardDetailsScreen() {
    Column(Modifier.fillMaxSize()) {
        TwoLinesText(
            modifier = Modifier,
            headerText = "11",
            descriptionText = "121"
        )
        Row() {
            TwoLinesText(
                modifier = Modifier,
                headerText = "11",
                descriptionText = "121"
            )
            TwoLinesText(
                modifier = Modifier,
                headerText = "11",
                descriptionText = "121"
            )
        }
    }
}


@Preview
@Composable
fun CardDetailsScreenPreview() {
    Surface() {
        CardDetailsScreen()
    }
}