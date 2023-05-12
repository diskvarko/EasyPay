package com.example.easypay.presentation.paymentScreen.card

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easypay.ui.theme.BlueDeepDark
import com.example.easypay.ui.theme.BlueDeepLight
import com.example.easypay.ui.theme.GrayLight
import com.example.easypay.ui.theme.GraySuperLight
import com.example.easypay.ui.theme.Poppins

@Composable
fun CardItem(modifier: Modifier = Modifier) {
    Box(
        modifier
            .background(
                color = BlueDeepDark,
                shape = RoundedCornerShape(percent = 20)
            )
            .size(width = 300.dp, height = 200.dp)

    ) {
        Box(
            Modifier
                .padding(top = 40.dp)
                .background(color = BlueDeepLight)
                .size(width = 335.dp, height = 40.dp),
        )
        Box(
            Modifier
                .padding(top = 60.dp)
                .fillMaxSize()
                .align(alignment = Alignment.Center)
        ) {
            Box(
                Modifier
                    .background(color = GraySuperLight)
                    .size(width = 230.dp, height = 40.dp)
                    .align(alignment = Alignment.Center),
            )
            Text(
                modifier = Modifier
                    .padding(end = 50.dp)
                    .align(Alignment.CenterEnd),
                text = "123",
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            )
            MyCircle(
                modifier = Modifier
                    .padding(end = 83.dp, bottom = 50.dp)
                    .align(Alignment.CenterEnd)
            )

        }
    }
}

@Composable
fun MyCircle(modifier: Modifier = Modifier) {
    val radius = 65f
    val animateFloat = remember { Animatable(0f) }
    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = infiniteRepeatable(tween(durationMillis = 3000, easing = LinearEasing))
        )
    }

    Canvas(modifier = modifier) {
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 360f * animateFloat.value,
            useCenter = false,
            topLeft = Offset(size.width / 4, size.height / 4),
            size = Size(
                radius * 2,
                radius * 2
            ),
            style = Stroke(2.0f)
        )
    }
}

@Preview
@Composable
fun CardItemPreview() {
    MyCircle()
}

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .padding(bottom = 25.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "What is CVC code?",
            color = GrayLight,
            modifier = modifier
                .align(CenterHorizontally)
                .padding(top = 15.dp)
        )
        CardItem(
            modifier
                .align(CenterHorizontally)
                .padding(10.dp))
        Text(
            text = "The CVV/CVC code (Card Verification Value/Code) is located on the back of your credit/debit card on the right side of the white signature strip; it is always the last 3 digits in case of VISA and MasterCard.",
            modifier = modifier
                .align(CenterHorizontally),
            color = GrayLight,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview
@Composable
fun BottomSheetScreenPrev() {
    BottomSheetContent()
}