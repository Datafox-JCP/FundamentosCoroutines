package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.*
import java.lang.ArithmeticException

/*
Manejo de expeciones

El comportamiento de la excepción depende del constructor de la coroutine

launch
    - Se propaga por toda la jerarquí padre-hijo
    - La excepción se da de inmediato y todos los jon¡bs fallan
    - Usar try-catch o exception handler

async
    - Las excepciones se presentan hasta que el resultado es consumido
    - Si el resultado no es consumido, la excepción no se presenta
    - Usar try-catch en la coroutine o en la llamada await()
 */

fun main() {
    runBlocking {
        // 2. Añadir el manejador
        val miManejador = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Manejador excepción: ${throwable.localizedMessage}")
        }

        // 3. añadir el manejador al launch()
        val tarea = GlobalScope.launch(miManejador) {
            println("Arrojar una excepción para la tarea")
            throw IndexOutOfBoundsException("Ha ocurrido un error en la coroutine") // 4. Añadir el mensaje
        }
        tarea.join() // 1. Esto arroja la excepción

        val retrasada = GlobalScope.async {
            println("Arrojar una excepción para async")
            throw ArithmeticException("Excepcion ")
        }
        try {
            retrasada.await() // Se arrojará excepción de await, usar try-cacth
        } catch (e: java.lang.ArithmeticException) {
            println("Se atrapó ArithmeticExcepcion ${e.localizedMessage}")
        }
    }
}