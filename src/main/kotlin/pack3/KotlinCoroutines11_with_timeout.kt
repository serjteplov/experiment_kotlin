package pack3

import kotlinx.coroutines.*

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    val result: String? = withTimeoutOrNull(2000) {
        for (i in 0..500) {
            print("$i.")
            delay(50)
        }

        "I'm done"
    }

    println("\nresult = ${result}")
    println("End. Thread: ${Thread.currentThread().name}")
}

