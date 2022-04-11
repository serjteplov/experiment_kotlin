package pack1

import kotlinx.coroutines.*

suspend fun main() {

    coroutineScope {
        val message = async(start = CoroutineStart.LAZY) { getMessage1() }

        delay(5000L)
        println("program starting")
        println("message: ${message.await()}")
        println("program finished")
    }
}

suspend fun getMessage1(): String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}
