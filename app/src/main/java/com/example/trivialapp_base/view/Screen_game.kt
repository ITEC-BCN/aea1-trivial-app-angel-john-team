package com.example.trivialapp_base.view

import android.graphics.Paint
import android.text.Layout
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.model.Pregunta

@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {
    viewModel.setPreguntaActual()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text( text = "Round " + viewModel.indicePreguntaActual + "/10",
                fontSize = 25.sp)
            Spacer( modifier = Modifier.height(10.dp) )

            CircularProgressIndicator(
                progress = {viewModel.tiempoRestante / 100f}
            )
            Spacer( modifier = Modifier.height(10.dp) )

            Text( text = viewModel.preguntaActual?.pregunta ?: "Pregunta",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer( modifier = Modifier.height(10.dp) )
            Row() {
                Button(onClick = {
                    viewModel.responderPregunta(viewModel.preguntaActual?.respuesta1)
                    viewModel.cargarSiguientePregunta()
                },
                  modifier = Modifier
                      .width(150.dp)
                      .height(60.dp)
                ) {
                    Text(text = viewModel.preguntaActual?.respuesta1 ?: "Respuesta 1")
                }
                Spacer( modifier = Modifier.width(10.dp) )
                Button(onClick = {
                    viewModel.responderPregunta(viewModel.preguntaActual?.respuesta2)
                    viewModel.cargarSiguientePregunta()
                },
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                ) {
                    Text(text = viewModel.preguntaActual?.respuesta2 ?: "Respuesta 2")
                }
            }
            Spacer( modifier = Modifier.height(10.dp) )
            Row() {
                Button(onClick = {
                    viewModel.responderPregunta(viewModel.preguntaActual?.respuesta3)
                    viewModel.cargarSiguientePregunta()
                },
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                ) {
                    Text(text = viewModel.preguntaActual?.respuesta3 ?: "Respuesta 3")
                }
                Spacer( modifier = Modifier.width(10.dp) )
                Button(onClick = {
                    viewModel.responderPregunta(viewModel.preguntaActual?.respuesta4)
                    viewModel.cargarSiguientePregunta()
                },
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp)
                ) {
                    Text(text = viewModel.preguntaActual?.respuesta4 ?: "Respuesta 4")
                }
            }
            if (viewModel.juegoTerminado){
                navController.navigate("ResultScreen")
                viewModel.stopTimer()
            }
        }
    }
}