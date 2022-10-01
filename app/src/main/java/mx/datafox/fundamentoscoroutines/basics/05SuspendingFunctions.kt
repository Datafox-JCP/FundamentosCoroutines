package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
Suspending functions

Son funciones que pueden ejecutar en la coroutine

Hacen que los callbacks sean simples
 */

var llamadas = 0 // variable global a actualizar

fun main() {
    GlobalScope.launch { completarMensaje() }
    GlobalScope.launch { mejorarMensaje() }
    print("¡Hola, ")
    Thread.sleep(2_000L)
    println("Se han realizado $llamadas llamadas hasta ahora")
}

suspend fun completarMensaje() {
    delay(500L)
    println("Mundo!")
    llamadas++
}

suspend fun mejorarMensaje() {
    delay(1_000L)
    println("Es genial poder suspender una función")
    llamadas++
}

/*
Una función de callback es una función que se pasa a otra función como un argumento, que luego se invoca dentro de la función externa para completar algún tipo de rutina o acción.
 */