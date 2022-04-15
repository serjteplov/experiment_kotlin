package pack3

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    println("Start. Thread: ${Thread.currentThread().name}")

    launch {
        println("Fake work start. Thread: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished. Thread: ${Thread.currentThread().name}")
    }

    delay(2000)

    println("End. Thread: ${Thread.currentThread().name}")

}