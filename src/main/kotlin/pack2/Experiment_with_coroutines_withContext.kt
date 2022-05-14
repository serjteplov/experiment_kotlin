package pack2

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    val awaited = withContext (Dispatchers.Default) {
        anotherSuspend()
    }

    /*
    Использование withContext аналогично данному коду:

    val result = GlobalScope.async (Dispatchers.Default) {
        anotherSuspend()
    }
    val awaited = result.await()

    */

    println("awaited = ${awaited}")
    println("After")
}

suspend fun anotherSuspend(): Int {
    delay(1000)
    return 42
}