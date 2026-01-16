package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.R
import com.example.trivialapp_base.viewmodel.GameViewModel



@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Trivial A&J",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
        )
        Image(
            painter = painterResource(id = R.drawable.logotrivial),
            contentDescription = "Hola",
            contentScale = ContentScale.FillWidth
        )
    }
}