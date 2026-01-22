package com.example.trivialapp_base.view

import android.graphics.Paint
import android.text.Layout
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    Box() {
         CircularProgressIndicator()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text("Pregunta")
            Text( text = viewModel.preguntaActual?.pregunta ?: "")

            Row() {
                Button(onClick = {

                }) {
                    Text("Respuesta 1")
                }
                //Spacer( modifier = Modifier )
                Button(onClick = {

                }) {
                    Text("Respuesta 2")
                }
            }
            Row() {
                Button(onClick = {

                }) {
                    Text("Respuesta 3")
                }
                Button(onClick = {

                }) {
                    Text("Respuesta 4")
                }
            }
        }
    }
    Box() {

    }
}