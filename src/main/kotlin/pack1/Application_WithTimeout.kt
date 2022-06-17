package pack1

import kotlinx.coroutines.*

suspend fun main() {

    println("program starting")
    var message: String? = null

    val mes = withTimeout(30000) {
        println("My context is: $coroutineContext")
        message = getMessage8()
        queryDb8()
        queryWeb8()
        //launch { queryDb6() }
        //launch { queryWeb6() }
        10
    }

//    job.join()
    Thread.sleep(1000)
    println("message: $message")
    println("program finished $mes is here")
}

suspend fun getMessage8() : String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryDb8() {
    println("Entering in queryDb")
    delay(1000L)
    println("Exiting from queryDb")
}

suspend fun queryWeb8() {
    println("Entering in queryWeb")
    delay(10000L)
    println("Exiting from queryWeb")
}
