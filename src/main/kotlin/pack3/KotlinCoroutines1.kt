package pack3

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    println("Start. Thread: ${Thread.currentThread().name}")

    // new coroutine, non blocking main thread
    GlobalScope.launch {
        println("Fake work start. Thread: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake work finished. Thread: ${Thread.currentThread().name}")
    }
    //new coroutine, blocking main thread
    runBlocking {
        delay(2000)
    }

    println("End. Thread: ${Thread.currentThread().name}")

}