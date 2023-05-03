package com.example.easypay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easypay.ui.theme.BlueHeaderText
import com.example.easypay.ui.theme.BlueLight
import com.example.easypay.ui.theme.BlueMain
import com.example.easypay.ui.theme.GrayLight
import com.example.easypay.ui.theme.GraySuperLight
import com.example.easypay.ui.theme.Poppins
import com.example.easypay.ui.theme.buttonStyle
import com.example.easypay.ui.theme.lightStyle1
import com.example.easypay.ui.theme.lightStyle2

@Composable
fun ButtonActive(modifier: Modifier = Modifier, text: String, action: () -> Unit) {
    Button(
        onClick = action,
        shape = RoundedCornerShape(percent = 25),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = BlueMain,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 20.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 20.dp)

    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.buttonStyle
        )
    }
}

@Composable
fun InputField(modifier: Modifier = Modifier, text: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Gray.copy(alpha = 0.05f),
            focusedBorderColor = BlueLight,
            unfocusedBorderColor = GraySuperLight,
            cursorColor = BlueLight,
            errorBorderColor = Color.Red
        )
    )
}

@Composable
fun HeaderText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 20.sp,
        fontFamily = Poppins,
        color = BlueHeaderText
    )
}

@Composable
fun TwoLinesText(modifier: Modifier, headerText: String, descriptionText: String) {
    Column(Modifier.padding(10.dp)) {
        Text(
            text = headerText,
            modifier = modifier,
            style = MaterialTheme.typography.lightStyle1,
            color = GrayLight
        )
        Text(
            text = descriptionText,
            modifier = modifier,
            style = MaterialTheme.typography.lightStyle2,
            color = Color.Black.copy(alpha = 0.6f)
        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(GraySuperLight)
        )
    }
}

@Preview
@Composable
fun TextInputPreview() {
    InputField(Modifier, "qqqqq", { "" })
    HeaderText(text = "")
}

@Preview
@Composable
fun TwoLinesTextPrev() {
    TwoLinesText(Modifier, "CATEGORY", "LIGHT")
}