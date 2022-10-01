package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Context (contexto)

Un contexto es un conjunto de datos relacionados a la coroutine
Todas las coroutines tienen asociado un contexto

Elementos importantes de un contexto:
    - Dispatcher - en qué hilo se ejecuta la coroutine
    - Job - maneja el ciclo de vida de la coroutine

La diferencia entre scope y context es que scope (ámbito) es usado para crear y manejar coroutines y context (contexto) son datos y variables asociados a la coroutine

 */
fun main() {
    runBlocking {
        // con CoroutineName() le damos un nombre al hilo de la coroutine
        launch(CoroutineName("miCoroutine")) {
            println("Se ejecuta desde el hilo ${coroutineContext[CoroutineName.Key]}")
            println("Se ejecuta desde el hilo principal -${Thread.currentThread().name}-")
        }
    }
}