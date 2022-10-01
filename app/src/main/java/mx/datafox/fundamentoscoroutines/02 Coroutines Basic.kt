package mx.datafox.fundamentoscoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce


fun main() {
    // globalScope()
    // suspendFun()
    newTopic("Constructores de coroutines")
    // cRunBlocking()
    // cLaunch()
    // cAsync()
    // job()
    // deferred()
    cProduce()
    readLine()
}

fun cProduce() = runBlocking {
    newTopic("Produce")
    val names = produceNames()
    names.consumeEach { println(it)}
}

fun CoroutineScope.produceNames(): ReceiveChannel<String> = produce {
    (1..5).forEach { send("name $it") }
}

fun deferred() {
    runBlocking {
        newTopic("Deferred ideal para devolver un  valor")
        val deferred = async {
            startMsg()
            delay(someTime())
            println("deferred...")
            endMsg()
            multi(5, 2)
        }
        println("Deferred: $deferred")
        println("Valorde deferred.await: ${deferred.await()}")

        val result = async {
            multi(3,3)
        }.await()
        println("Result: $result")
    }
}

fun job() {
    runBlocking {
        newTopic("Job se puede cancelar")
        val job = launch {
            startMsg()
            delay(2_100)
            println("job...")
            endMsg()
        }
        println("Job: $job")

        println("isActive: ${job.isActive}")
        println("isCancel: ${job.isCancelled}")
        println("isComplet: ${job.isCompleted}")

        delay(someTime())
        println("Tarea cancelada o interrumpida")
        job.cancel()

        println("isActive: ${job.isActive}")
        println("isCancel: ${job.isCancelled}")
        println("isComplet: ${job.isCompleted}")
    }
}

fun cAsync() {
    runBlocking {
        newTopic("Async (devuelve un valor")
        val result = async {
            startMsg()
            delay(someTime())
            println("async...")
            endMsg()
            "Hola"
        }
        println("Result: ${result.await()}")
    }
}

fun cLaunch() {
    runBlocking {
        newTopic("Launch no devuelve nada")
        launch {
            startMsg()
            delay(someTime())
            println("launch...")
            endMsg()
        }
    }
}

fun cRunBlocking() {
    newTopic("RunBlocking")
    runBlocking {
        startMsg()
        delay(someTime())
        println("runBlocking...")
        endMsg()
    }
}

fun suspendFun() {
    newTopic("Suspend")
    Thread.sleep(someTime())
    GlobalScope.launch { delay(someTime()) }
}

fun globalScope() {
    newTopic("Global Scope")
    GlobalScope.launch {
        startMsg()
        delay(someTime())
        println("Mi coroutine")
        endMsg()
    }
}

fun startMsg() {
    println("Comenzando coroutine -${Thread.currentThread().name}-")
}

fun endMsg() {
    println("Coroutine finalizada -${Thread.currentThread().name}-")
}
