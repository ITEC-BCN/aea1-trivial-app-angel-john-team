package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import com.example.trivialapp_base.view.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrivialAPP_BaseTheme {
                // Controlador de navegación
                val navigationController = rememberNavController()
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.MenuScreen.route
                ) {
                    composable(Routes.MenuScreen.route) { Screen1(navigationController) }
                    composable(Routes.GameScreen.route) { Screen2(navigationController) }
                    composable(Routes.ResultScreen.route) { Screen3(navigationController) }
                }
            }


                // Instanciamos el ViewModel una vez



                // Definición de rutas y navegación



            }
        }
    }
}