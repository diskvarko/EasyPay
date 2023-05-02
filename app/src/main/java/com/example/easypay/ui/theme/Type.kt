package com.example.easypay.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.easypay.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
val Typography.buttonStyle: TextStyle
    get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp,
        color = Color.White
    )

val Typography.headerStyle: TextStyle
    get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = BlueMain
    )

val Typography.normalStyle: TextStyle
    get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        color = Color.White
    )

val Typography.lightStyle1: TextStyle
    get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
    )

val Typography.lightStyle2: TextStyle
    get() = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp
    )

val Poppins = FontFamily(
    fonts = listOf(
        Font(R.font.poppins_bold, weight = FontWeight.Bold),
        Font(R.font.poppins_light, weight = FontWeight.Light),
        Font(R.font.poppins_black, weight = FontWeight.Normal)
    )
)