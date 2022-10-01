package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.*

/*
Dispatchers

Un dispatcher determina en que hilo (thread) o thread pool se ejecutará la coroutine

Se dispone de diferentes dispatchers dependiendo de la tarea

    - Main
        El Main thread actualiza la UI de aplicaciones (Android)
        Main dispatcher debe ser definido en Gradle (se hace de forma automática al crear el proyecto)

    - Default
        Es útil para trabajos que requieran un uso intenso del CPU (procesamiento de imágenes, bases de datos)

    - IO
        Es útil para comunicaciones de red o lectura/escritura de archivos

    - Unconfined
        Inicia la coroutina en el dispatcher heredado del que la llama

    - newSingleThreadContext("MyThread")
        Para forzar a la crreación de un nuevo thread

Los dispatchers se declaran como parámetro de launch()
 */

fun main() {
    runBlocking {
        /*
        Este se ejecuta en dispositivos Android
        launch(Dispatchers.Main) {
            println("Main dispatcher. Thread: ${Thread.currentThread().name}")
        }*/

        launch(Dispatchers.Unconfined) {
            println("Unconfined: Thread: ${Thread.currentThread().name}")
            delay(100L)
            println("Unconfined2. Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default. Thread: Thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO. Thread: ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyThread")) {
            println("newSingleThread: Thread: ${Thread.currentThread().name}")
        }
    }
}