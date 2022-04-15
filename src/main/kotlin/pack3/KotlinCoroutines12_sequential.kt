package pack3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()
        println("msg = ${msgOne + msgTwo}")
    }

    println("time = ${time}")
    println("End. Thread: ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String {
    delay(1000) // pretend to do some work
    return "Hello "
}

suspend fun getMessageTwo(): String {
    delay(1000) // pretend to do some work
    return "world!"
}
