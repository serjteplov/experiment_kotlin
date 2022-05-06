package pack1

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.coroutines.suspendCoroutine

//suspend fun main() {
//    println("Program starts")
//
//    suspendCoroutine<String> {cont->
//
//        val mess = getMess4()
//        val answerPostgres = queryPostgres4()
//        val answerGoogle = queryGoogle4()
//
//        println("mess = $mess")
//        println("answerPostgres = $answerPostgres")
//        println("answerGoogle = $answerGoogle")
//    }
//
//    println("Program ends")
//}
//
//suspend fun getMess4(): String {
//    println("Entering in getMessage")
//    delay(3000L)
//    println("Exiting from getMessage")
//    return "Hello"
//}
//
//suspend fun queryPostgres4(): String {
//    println("Entering in queryPostgres")
//    delay(1000L)
//    println("Exiting from queryPostgres")
//    return "Postgres done"
//}
//
//suspend fun queryGoogle4(): String {
//    println("Entering in queryGoogle")
//    delay(5000L)
//    println("Exiting from queryGoogle")
//    return "Google done"
//}
//
//
