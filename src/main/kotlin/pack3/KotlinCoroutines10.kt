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
            println("Exception caught safely: ${e.message}")
        } finally {
            println("Close resources in finally block")
        }

    }

    delay(50)
    job.cancel(CancellationException("My own crash message"))
    job.join()

    println("End. Thread: ${Thread.currentThread().name}")

}

