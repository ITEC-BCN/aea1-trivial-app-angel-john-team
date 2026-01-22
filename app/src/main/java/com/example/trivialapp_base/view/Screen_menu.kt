package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.R
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.viewmodel.GameViewModel


@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel) {
    var selectedDifficulty: String by remember {mutableStateOf("Seleccionar dificultad")}
    var expanded: Boolean by remember { mutableStateOf(false) }
    val difficulties = listOf("Facil", "Medio", "Dificil")

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
        ) {
            Image(
                painter = painterResource(id = com.example.trivialapp_base.R.drawable.hola),
                contentDescription = "Logo trivial",
                alpha = 1f
            )
            Text(
                text = "Trivial Homero",
                fontSize = 32.sp
            )
            Button(
                onClick = {expanded = true},
                modifier = Modifier
                    .width(200.dp)
            ) {
                Text(text = selectedDifficulty)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {expanded = false},
                modifier = Modifier
                    .width(200.dp)
            ) {
                difficulties.forEach { difficulties ->
                    DropdownMenuItem(
                        text = {Text(text = difficulties)},
                        onClick = {
                            expanded = false
                            selectedDifficulty = difficulties

                        }
                    )
                }
            }
            Button(
                onClick = {
                    viewModel.setDificultad(selectedDifficulty)
                    navController.navigate("GameScreen") },
                modifier = Modifier
                    .width(200.dp)
            ) {
                Text(text = "Nuevo juego")
            }
        }

    }
}
