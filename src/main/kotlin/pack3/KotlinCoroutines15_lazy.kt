package pack3

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val msgOne = async(start = CoroutineStart.LAZY) { getMessageOne4() }
    val msgTwo = async(start = CoroutineStart.LAZY) { getMessageTwo4() }
    //println("msg = ${msgOne.await() + msgTwo.await()}")

    println("End. Thread: ${Thread.currentThread().name}")
}

suspend fun getMessageOne4(): String {
    delay(1000) // pretend to do some work
    println("After working getMessageOne")
    return "Hello "
}

suspend fun getMessageTwo4(): String {
    delay(1000) // pretend to do some work
    println("After working getMessageTwo")
    return "world!"
}
