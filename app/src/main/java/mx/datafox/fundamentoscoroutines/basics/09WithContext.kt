package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/*
withContext

Permite cambiar el contexto con facilidad
Permite cambiar entre dispatchers.

 */

fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("Primer conexto: $coroutineContext")
            withContext(Dispatchers.IO) {
                println("Segundo contexto: $coroutineContext")
            }
            println("Tercer contextp: $coroutineContext")
        }
    }
}