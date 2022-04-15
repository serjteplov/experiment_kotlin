package pack3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val msgOne = async { getMessageOne2() }
        val msgTwo = async { getMessageTwo2() }
        println("msg = ${msgOne.await() + msgTwo.await()}")
    }

    println("time = ${time}")
    println("End. Thread: ${Thread.currentThread().name}")
}

suspend fun getMessageOne2(): String {
    delay(1000) // pretend to do some work
    return "Hello "
}

suspend fun getMessageTwo2(): String {
    delay(1000) // pretend to do some work
    return "world!"
}
