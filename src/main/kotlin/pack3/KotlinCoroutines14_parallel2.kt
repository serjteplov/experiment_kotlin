package pack3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val msgOne = launch { getMessageOne3() }
        val msgTwo = launch { getMessageTwo3() }
        msgOne.join()
        msgTwo.join()
    }

    println("time = ${time}")
    println("End. Thread: ${Thread.currentThread().name}")
}

suspend fun getMessageOne3(): String {
    delay(1000) // pretend to do some work
    return "Hello "
}

suspend fun getMessageTwo3(): String {
    delay(1000) // pretend to do some work
    return "world!"
}
