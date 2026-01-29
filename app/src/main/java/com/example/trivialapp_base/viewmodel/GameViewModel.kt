package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    var puntuacion by mutableIntStateOf(0)
        private set

    var juegoTerminado by mutableStateOf(false)

    private var timer: CountDownTimer? = null

    var tiempoRestante by mutableFloatStateOf(100f)
        private set
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons
    var dificultadSeleccionada by mutableStateOf("Facil")
        private set

    var preguntasPartida: List<Pregunta> = emptyList()
        private set

    public fun setPreguntasPartida (){
        preguntasPartida = filtrarPreguntas()
    }

    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var indicePreguntaActual by mutableIntStateOf(1)
        private set


    private fun iniciarTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 100) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = (millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA) * 100f
            }

            override fun onFinish() {
                tiempoRestante = 0f
                responderPregunta(null)
                cargarSiguientePregunta()
            }
        }.start()
    }

    public fun stopTimer(){
        timer?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
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
        if (indicePreguntaActual > 10){
            juegoTerminado = true
        }
    }

    public fun setPreguntaActual (){
        preguntaActual = preguntasPartida[indicePreguntaActual]
        iniciarTimer()
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
}