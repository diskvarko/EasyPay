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
        Surface(Modifier.fillMaxSize()) {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Column {
        StartScreen(
            Modifier
                .weight(2f)
                .padding(vertical = 70.dp)
        )
        ButtonActive(
            text = "New payment"
        ) {

        }
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