package pack1

import kotlinx.coroutines.*

suspend fun main() {

    println("Program starts")
     coroutineScope {

        val mess = async { getMessage() }
        val answerPostgres = async { queryPostgres() }
        val answerGoogle = async { queryGoogle() }

        mess.await()
        answerPostgres.await()
        answerGoogle.await()

    }
    println("Program ends")
}

suspend fun getMessage(): String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryPostgres(): String {
    println("Entering in queryPostgres")
    delay(3000L)
    println("Exiting from queryPostgres")
    return "Postgres done"
}

suspend fun queryGoogle(): String {
    println("Entering in queryGoogle")
    delay(3000L)
    println("Exiting from queryGoogle")
    return "Google done"
}


