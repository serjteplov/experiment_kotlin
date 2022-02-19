package pack1

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

fun main() = runBlocking<Unit> {
    launch {
        scopeCheck(this)
    }
}

suspend fun scopeCheck(scope: CoroutineScope) {
    println("My context is: $coroutineContext")

    println(scope.coroutineContext === coroutineContext)
}