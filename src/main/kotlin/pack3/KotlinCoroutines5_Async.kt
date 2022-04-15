package pack3

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val jobDeferred: Deferred<Int> = async {
        println("Fake work start. Thread: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished. Thread: ${Thread.currentThread().name}")
        15
    }

    val await: Int = jobDeferred.await()

    println("End. Thread: ${Thread.currentThread().name}")

}

suspend fun myOwnSuspendingFunction(time: Long) {
    delay(time)
}