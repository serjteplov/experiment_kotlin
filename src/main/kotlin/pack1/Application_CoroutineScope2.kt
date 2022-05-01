package pack1

import kotlinx.coroutines.*

suspend fun main() {
    println("program starting")

    var message: String?
    coroutineScope {
        println("My context is: $coroutineContext")
        message = getMessage6()
        queryDb6()
        queryWeb6()
        //launch { queryDb6() }
        //launch { queryWeb6() }
    }

    println("message: $message")
    println("program finished")
}

suspend fun getMessage6() : String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryDb6() {
    println("Entering in queryDb")
    delay(1000L)
    println("Exiting from queryDb")
}

suspend fun queryWeb6() {
    println("Entering in queryWeb")
    delay(10000L)
    println("Exiting from queryWeb")
}
