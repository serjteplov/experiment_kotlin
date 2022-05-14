package pack2

import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    println("Before")

    sleeping()

    println("After")
}

suspend fun sleeping() = suspendCoroutine<Unit> { continuation ->
    thread {
        println("Suspended")
        Thread.sleep(1000)
        continuation.resume(Unit)
        println("Resumed")
    }
}