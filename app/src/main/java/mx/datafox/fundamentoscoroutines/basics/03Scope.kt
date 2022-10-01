package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.*

/*
Scope (ámbito)

Proporciona los métodos del ciclo de vida para las coroutines lo que nos permite iniciarlas y deternarlas

GlobalScope.launch{} - El ámbito de la coroutine es el ciclo de vida de toda la aplicación (usualmente no se usa)
runBlocking - Crea un ámbito y ejecuta dentro de este la coroutine, tampoco se usa regularmente
coroutineScope{} - Crea un nuevo ámbito y no se completa hasta que todas las coroutinas hijas se hayan completado
 */

fun main() {
    println("La ejecución del programa será bloqueada")

    runBlocking {
        launch {
            delay(2_000L) // delay usa Longs, reemplaza a Thread.sleep()
            println("Primera tarea desde runBlocking")
        }
        // runBlocking bloquea el hilo principal por lo que no se debe usar en producción

        GlobalScope.launch {
            delay(1_000L)
            println("Segunda tarea desde GlobalScope")
        }

        coroutineScope {
            launch {
                delay(2_000L)
                println("Tercera tarea de coroutineScope")
            }
        }
    }
    println("Continua la ejecución del programa")
}

/*
¿Por qué no se ejecutar en orden?
 */