package pack2

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    some {
        delay(1000)
        launch {
            val i = 10
        }
        43
    }
    some2 {
        delay(1000)
        launch {
            val i = 10
        }
        55
    }
}

suspend fun some(block: suspend CoroutineScope.() -> Int): Int {
    val scope = CoroutineScope(Dispatchers.IO)
    block.invoke(scope)
    delay(1000)
    return 42
}

fun some2(block: () -> Int): Int {
    val scope = CoroutineScope(Dispatchers.IO)
    block.invoke()
    delay(1000)
    return 43
}