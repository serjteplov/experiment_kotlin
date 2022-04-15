package pack3

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val job: Job = launch {
        println("Fake work start. Thread: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished. Thread: ${Thread.currentThread().name}")
    }

    job.join()

    println("End. Thread: ${Thread.currentThread().name}")

}