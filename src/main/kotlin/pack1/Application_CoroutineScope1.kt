package pack1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main() {
    println("Program starts")

    coroutineScope {

        val mess = getMess3()
        val answerPostgres = queryPostgres3()
        val answerGoogle = queryGoogle3()

        println("mess = $mess")
        println("answerPostgres = $answerPostgres")
        println("answerGoogle = $answerGoogle")
    }

    println("Program ends")
}

suspend fun getMess3(): String {
    println("Entering in getMessage")
    delay(3000L)
    println("Exiting from getMessage")
    return "Hello"
}

suspend fun queryPostgres3(): String {
    println("Entering in queryPostgres")
    delay(1000L)
    println("Exiting from queryPostgres")
    return "Postgres done"
}

suspend fun queryGoogle3(): String {
    println("Entering in queryGoogle")
    delay(5000L)
    println("Exiting from queryGoogle")
    return "Google done"
}


