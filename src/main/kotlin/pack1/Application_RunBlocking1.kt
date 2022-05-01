package pack1

import kotlinx.coroutines.*

fun main() {

    println("program starting")
    var message: String

    runBlocking {
        println("My context is: $coroutineContext")
        message = getMessage3()
        launch { queryDb3() }
        launch { queryWeb3() }
    }

    Thread.sleep(500)
    println("message: $message")
    println("program finished")
}

suspend fun getMessage3() : String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryDb3() {
    println("Entering in queryDb")
    delay(1000L)
    println("Exiting from queryDb")
}

suspend fun queryWeb3() {
    println("Entering in queryWeb")
    delay(1000L)
    println("Exiting from queryWeb")
}