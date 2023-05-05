package com.example.easypay.presentation.paymentScreen

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.easypay.R
import com.example.easypay.presentation.common.animations.DotsFlashing
import com.example.easypay.ui.theme.GrayLight
import com.example.easypay.ui.theme.lightStyle1
import com.example.easypay.ui.theme.lightStyle2
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScanCardScreen(
    amount: String,
    paymentMethod: String,
    onResultGo: (amount: String, paymentMethod: String) -> Unit
) {
    val viewModel = viewModel<PaymentViewModel>()
    val text = viewModel.listCardAnimations.collectAsState(initial = "Attach a card")
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.nfc_logo),
            contentDescription = null
        )
        Text(
            text = "Amount: $amount $",
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            fontSize = 25.sp,
            style = MaterialTheme.typography.lightStyle2
        )
        AnimatedContent(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            targetState = text,
            transitionSpec = {
                slideInHorizontally { -it } + fadeIn() with
                        slideOutHorizontally { it } + fadeOut() using
                        SizeTransform(clip = false)
            }
        ) { content ->
            Text(
                text = content.value,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp),
                fontSize = 25.sp,
                style = MaterialTheme.typography.lightStyle1,
                color = GrayLight
            )
        }
        DotsFlashing(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
    }
    LaunchedEffect(true) {
        delay(7000)
        onResultGo.invoke(amount, paymentMethod)
    }
}
