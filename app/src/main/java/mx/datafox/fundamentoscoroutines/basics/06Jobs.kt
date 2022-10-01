package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Jobs

Una job es una ejecución de una coroutine. La llamada .launch() devuelve un job

Permiten manipular el ciclo de vida de la coroutine

Viven (se ejecutan) en la jerarquía de otros jobs, tienen padres e hijos

Pueden acceder a métodos y variables del ciclo de vida:
    - cancel()
    - join()

Si se cancela un job, todos sus padres e hijos se cancelan
 */

fun main() {
    // Recordar: Se usa runblocking{} para declarar el ámbito de una coroutine
    runBlocking {
        val job1 = launch {
            // delay(3000L)
            println("Se lanza el Job1")
            val job2 = launch {
                println("Job2 en ejeución")
                delay(3_000L)
                println("Job2 terminando")
            }
            job2.invokeOnCompletion { println("Se ha completado el Job2") }

            val job3 = launch {
                println("Job3 en ejeución")
                delay(3_000L)
                println("Job3 terminando")
            }
            job3.invokeOnCompletion { println("Se ha completado el Job3") }
        }
        job1.invokeOnCompletion { println("Se ha completado el Job1") }

        delay(500L)
        println("Job1 se ha cancelado")
        job1.cancel()
    }
}

/*
¿por qué se completa primero el Job2 si se cancela el Job1?
 */