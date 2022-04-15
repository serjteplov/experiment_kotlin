package pack3

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {

        try {
            for (i in 0..500) {
                print("$i.")
                delay(5)
            }
        } catch (e: CancellationException) {
            println("Exception caught safely")
        } finally {
            println("Close resources in finally block")
        }

    }

    println("!!!!!!!!!!!")
    delay(50)
    job.cancelAndJoin()

    println("End. Thread: ${Thread.currentThread().name}")

}

