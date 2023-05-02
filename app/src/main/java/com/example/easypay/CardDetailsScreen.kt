package com.example.easypay

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easypay.ui.theme.BlueLight
import com.example.easypay.ui.theme.lightStyle2

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