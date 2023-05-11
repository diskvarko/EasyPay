package com.example.easypay.presentation.paymentScreen.card

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.easypay.R
import com.example.easypay.ui.theme.*

@Composable
fun CardItem(modifier: Modifier = Modifier) {
    Box(
        modifier
            .padding(start = 20.dp, end = 20.dp)
            .background(
                color = BlueDeepDark,
                shape = RoundedCornerShape(percent = 20)
            )
            .size(width = 335.dp, height = 200.dp)

    ) {
        Box(
            modifier
                .padding(top = 40.dp)
                .background(color = BlueDeepLight)
                .size(width = 335.dp, height = 40.dp),
        )
        Box(
            modifier
                .padding(top = 60.dp)
                .background(color = GraySuperLight)
                .size(width = 230.dp, height = 40.dp)
                .align(alignment = Alignment.Center),
        ) {
            Text(
                modifier = modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp),
                text = "123",
                fontFamily = Poppins,
                fontWeight = FontWeight.Light
            )
            MyCircle(
                modifier = modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 20.dp)
            )
        }
    }
}

@Composable
fun MyCircle(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier, onDraw = {
        drawCircle(
            color = Color.Red,
            radius = 65f,
            style = Stroke(width = 2.dp.toPx())
        )
    })
}

@Preview
@Composable
fun CardItemPreview() {
    //  CardItem()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
//    coroutineScope: CoroutineScope,
//    state: ModalBottomSheetState
) {
    Column(Modifier.padding(bottom = 25.dp, start = 20.dp, end = 20.dp)) {
        Row(
            modifier = modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "What is CVC code?",
                color = GrayLight,
                modifier = modifier
                    .padding(start = 20.dp)
                    .weight(3f)
                    .align(Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = null,
                modifier = modifier
                    .padding(start = 20.dp)
                    .weight(1.0f)
                    .clickable {
//                        coroutineScope.launch {
//                            state.hide()
//                        }
                    },
                tint = GrayLight.copy(alpha = 0.8f)
            )

        }
        CardItem()
        Text(
            text = "The CVV/CVC code (Card Verification Value/Code) is located on the back of your credit/debit card on the right side of the white signature strip; it is always the last 3 digits in case of VISA and MasterCard.",
            modifier = modifier.padding(20.dp),
            color = GrayLight
        )
    }
}

@Preview
@Composable
fun BottomSheetScreenPrev() {
    BottomSheetContent(

    )
}