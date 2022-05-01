package pack1

import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

suspend fun main() {

    println("program starting")
    var message: String? = null

    val job = CoroutineScope(context = EmptyCoroutineContext).launch {
        println("My context is: $coroutineContext")
        println("A context with name: ${coroutineContext + CoroutineName("test")}")
        message = getMessage7()
        launch { queryDb7() }
        launch { queryWeb7() }
    }

    job.join()
    println("message: $message")
    println("program finished")
}

suspend fun getMessage7(): String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryDb7() {
    println("Entering in queryDb")
    delay(1000L)
    println("Exiting from queryDb")
}

suspend fun queryWeb7() {
    println("Entering in queryWeb")
    delay(1000L)
    println("Exiting from queryWeb")
}
