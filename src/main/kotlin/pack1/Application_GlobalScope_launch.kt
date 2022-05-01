package pack1

import kotlinx.coroutines.*

suspend fun main() {

    println("program starting")
    var message: String? = null

    val job = GlobalScope.launch {
        println("My context is: $coroutineContext")
        message = getMessage5()
        queryDb6()
        queryWeb6()
//        launch { queryDb6() }
//        launch { queryWeb6() }
    }

//    job.join()
    Thread.sleep(10000)
    println("message: $message")
    println("program finished")
}

suspend fun getMessage5() : String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryDb5() {
    println("Entering in queryDb")
    delay(1000L)
    println("Exiting from queryDb")
}

suspend fun queryWeb5() {
    println("Entering in queryWeb")
    delay(2000L)
    println("Exiting from queryWeb")
}
