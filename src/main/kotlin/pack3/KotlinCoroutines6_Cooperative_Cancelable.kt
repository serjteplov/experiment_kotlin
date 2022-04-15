package pack3

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val job: Job = launch {

        for (i in 0..500) {
            print("$i.")
            delay(50)
        }

    }

    delay(2000)
    job.cancelAndJoin()

    println("End. Thread: ${Thread.currentThread().name}")

}

