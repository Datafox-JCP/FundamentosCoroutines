package mx.datafox.fundamentoscoroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Al usar coroutines no nos preocupará el impacto que procesos largos o complejos puedan tener
Las coroutines son muy ligeras y no saturan el dispositivo
 */

fun main() {

    // Muchos 😺
//    var inicio = System.currentTimeMillis()
//
//    repeat(1_000) {
//        print("\uD83D\uDE3A")
//    }
//
//    var fin = System.currentTimeMillis()
//
//    println()
//    var transcurrido = fin - inicio
//    println("Tiempo transcrurrido en segs.: $transcurrido")

    // Un millon de 😺
    // runBlocking se usa para iniciar la coroutine
    runBlocking {
        repeat(1_000_000) {
            launch {
                print("\uD83D\uDE3A")
            }
        }
    }
}