package pack1

import kotlinx.coroutines.*

suspend fun main() {
    println("Program starts")

    coroutineScope {
        val message = async(start = CoroutineStart.LAZY) { getMessage1() }
        //message.start() !!! Control asynchronous here

        println("program starting")
        println("message: ${message.await()}") // !!! Control asynchronous here
        println("program finished")
    }

    println("Program ends")
}

suspend fun getMessage1(): String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}
