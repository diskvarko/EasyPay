package com.example.easypay.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easypay.ui.theme.*

@Composable
fun ButtonActive(
    modifier: Modifier = Modifier,
    text: String,
    action: () -> Unit
) {
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
fun InputField(
    modifier: Modifier = Modifier,
    text: String,
    isError: Boolean,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    trailingIcon: @Composable() (() -> Unit)? = null,
    visualTransformation: VisualTransformation? = null
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        isError = isError,
        label = {
            if (label != null) {
                Text(
                    label, color = if (!isError) {
                        BlueLight
                    } else {
                        Color.Red
                    }
                )
            }
        },
        placeholder = {
            Text(text = placeholderText)
        },
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color.Gray.copy(alpha = 0.05f),
            focusedBorderColor = BlueLight,
            unfocusedBorderColor = GraySuperLight,
            cursorColor = BlueLight,
            errorBorderColor = Color.Red
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation ?: VisualTransformation.None
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
fun TwoLinesText(
    modifier: Modifier,
    item: Pair<String, String>
) {
    Column(Modifier.padding(10.dp)) {
        Text(
            text = item.first,
            modifier = modifier,
            style = MaterialTheme.typography.lightStyle1,
            color = GrayLight
        )
        Text(
            text = item.second,
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
