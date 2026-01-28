package com.example.trivialapp_base.viewmodel

import android.R
import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    var puntuacion by mutableIntStateOf(0)
        private set

    var juegoTerminado by mutableStateOf(false)
        //private set

//    public fun getJuegoTerminado(): Boolean{
//        return juegoTerminado
//    }
    private var timer: CountDownTimer? = null
    var tiempoRestante by mutableFloatStateOf(100f)
        private set
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons
    var dificultadSeleccionada by mutableStateOf("Facil")
        private set

    private var preguntasPartida: List<Pregunta> = filtrarPreguntas()

    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var indicePreguntaActual by mutableIntStateOf(0)
        private set

    fun iniciarJuego() {
        iniciarTimer()
    }

    public fun iniciarTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 100) {
            override fun onTick(millisUntilFinished: Long) {
                // Actualitzem l'estat directament
                tiempoRestante = millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA
            }

            override fun onFinish() {
                tiempoRestante = 0f

            }
        }.start()
    }


    public fun filtrarPreguntas(): MutableList<Pregunta> {
        val listaFiltrada = mutableListOf<Pregunta>()
        val listaPerFiltrar = ProveedorPreguntas.obtenerPreguntas()
        listaPerFiltrar.forEach() { preguntaFiltrar ->
            if (dificultadSeleccionada == preguntaFiltrar.dificultad){
                listaFiltrada.add(preguntaFiltrar)
            }
        }
        listaFiltrada.shuffle()
        return listaFiltrada
    }

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad // Sense .value!
    }



    public fun setIndicePreguntaActual(){
        indicePreguntaActual++
        if (indicePreguntaActual >= 10){
            juegoTerminado = true
        }
    }



    public fun setPreguntaActual (){
        preguntaActual = preguntasPartida[indicePreguntaActual]
    }
    public fun getDificultad(): String {
        return dificultadSeleccionada
    }

    public fun cargarSiguientePregunta() {
        setIndicePreguntaActual()
        setPreguntaActual()
    }

    public fun resetAll() {
        puntuacion = 0
        juegoTerminado = false
        indicePreguntaActual = 0
    }


    public fun responderPregunta(respuestaUsuario: String?) {
        if (respuestaUsuario == preguntaActual?.respuestaCorrecta){
            puntuacion += 10
        }
    }



    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }

}