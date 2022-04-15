package pack3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {


        launch {
            println("C2 = ${Thread.currentThread().name}")
        }


        // similar to GlobalScope
        // gets its own context ag Global Level
        launch(Dispatchers.Default) {
            println("C3 = ${Thread.currentThread().name}")
            delay(1000)
            println("C3 after delay = ${Thread.currentThread().name}")
        }


        // inherits CoroutineContext from immediate parent coroutine
        launch(Dispatchers.Unconfined) {
            println("C4 = ${Thread.currentThread().name}")
            delay(1000)
            println("C4 after delay = ${Thread.currentThread().name}")

            launch(coroutineContext) {
                println("C6 = ${Thread.currentThread().name}")
                delay(1000)
                println("C6 after delay = ${Thread.currentThread().name}")
            }

        }


        // context from parent to child
        launch(coroutineContext) {
            println("C5 = ${Thread.currentThread().name}")
            delay(1000)
            println("C5 after delay = ${Thread.currentThread().name}")
        }
    }
}

