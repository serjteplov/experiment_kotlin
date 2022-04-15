package pack3

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val job: Job = launch(Dispatchers.Default) {

        for (i in 0..500) {
            if (!isActive) {
                return@launch // or break
            }
            print("$i.")
            Thread.sleep(1)
        }

    }

    println("!!!!!!!!!!!")
    delay(5)
    job.cancelAndJoin()

    println("End. Thread: ${Thread.currentThread().name}")

}

