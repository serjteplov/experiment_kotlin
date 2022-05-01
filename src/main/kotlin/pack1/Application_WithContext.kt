package pack1

import kotlinx.coroutines.*

suspend fun main() {

    println("program starting")
    val message: String

    withContext(Dispatchers.IO) {
        println("My context is: $coroutineContext")
        message = getMessage4()
        currentCoroutineContext()
        GlobalScope.launch(context = currentCoroutineContext()) { queryDb4() }
        GlobalScope.launch(context = currentCoroutineContext()) { queryWeb4() }
    }

    delay(500L)
    println("message: $message")
    println("program finished")
}

suspend fun getMessage4() : String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryDb4() {
    println("Entering in queryDb")
    delay(1000L)
    println("Exiting from queryDb")
}

suspend fun queryWeb4() {
    println("Entering in queryWeb")
    delay(1000L)
    println("Exiting from queryWeb")
}
