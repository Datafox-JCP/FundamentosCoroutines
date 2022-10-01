package mx.datafox.fundamentoscoroutines.basics

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

/*
async

Igual que launch,pero devuelve un resultado en forma de Deferred

    Deferred - una promesa de devolver un valor

Cuando se necesita un valor se puede llamar a await() que es una blocking call
si el valor está disponible, se devuelve de inmediato y
si no está disponible, pausará el thread hasta que lo este

 */

fun main() {
    runBlocking {
        val primerDeferred = async { obtenerPrimerValor() }
        val segundoDeferred = async { obtenerSegundoValor() }

        println("Aquí se realizaría algún procesamiento")
        delay(500L)
        println("Esperando los valores")

        val primerValor = primerDeferred.await()
        val segundoValor = segundoDeferred.await()

        println("El total es ${primerValor + segundoValor}")
    }
}

// Recordar: Para llamar a una función desde una coroutine debe ser suspend
suspend fun obtenerPrimerValor(): Int {
    delay(1_000L)
    val valor = Random.nextInt(100)
    println("Devolviendo el primer: valor $valor")
    return valor
}

suspend fun obtenerSegundoValor(): Int {
    delay(2_000L)
    val valor = Random.nextInt(100)
    println("Devolviendo el segundo valor: $valor")
    return valor
}