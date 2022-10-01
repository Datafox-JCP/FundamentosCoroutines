package mx.datafox.fundamentoscoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    //lambda()
    //threads()
    coroutinesVsThreads()
    //sequences()
}

fun sequences() {
    newTopic("Sequences")
    getDataBySeq().forEach { println("${it}º") }
}

fun getDataBySeq(): Sequence<Float> {
    return sequence {
        (1..5).forEach {
            println("procesando datos...")
            Thread.sleep(someTime())
            yield(20 + it + Random.nextFloat())
        }
    }
}

fun coroutinesVsThreads() {
    newTopic("Coroutines vs Threads")
    runBlocking {
        (1..1_000_000).forEach { _ ->
            launch {
                delay(someTime())
                print("*")
            }
        }
    }

    /*(1..1_000_000).forEach {
        thread {
            Thread.sleep(someTime())
            println(˝"*")
        }
    }*/
}

private const val SEPARATOR = "===================="
fun newTopic(topic: String) {
    println("\n$SEPARATOR $topic $SEPARATOR\n")
}

fun threads() {
    newTopic("Threads")
    println("Thread ${multiThread(2, 3)}")
    multiThreadLambda(2, 3){
        println("Thread+Lambda $it")
    }
}

fun multiThread(x: Int, y: Int): Int {
    var result = 0

    thread {
        Thread.sleep(someTime())
        result = x * y
    }

    //Thread.sleep(2_100)
    return result
}

fun multiThreadLambda(x: Int, y: Int, callback: (result: Int)->Unit) {
    var result = 0

    thread {
        Thread.sleep(someTime())
        result = x * y
        callback(result)
    }
}

fun someTime(): Long = Random.nextLong(500, 2_000)

fun lambda() {
    newTopic("Lambda")
    println(multi(2, 3))

    multiLambda(2, 3) { result ->
        println(result)
    }
}

fun multiLambda(x: Int, y: Int, callback: (result: Int)->Unit) {
    callback(x * y)
}

fun multi(x: Int, y: Int): Int {
    return x * y
}