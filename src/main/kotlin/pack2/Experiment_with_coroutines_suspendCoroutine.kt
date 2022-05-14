package pack2

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// не понятно, почему в данном случае все три корутины не стартуют одновременно
// ведь suspendDelay2() саспендит корутину и при этом тред должен становиться свободным и
// освобождаться для других корутин
// если использовать обычный метод delay(...) - всё работает как и ожидается

// ОТВЕТ: надо создавать отдельный тред, см функцию suspendDelay3_working

fun main() = runBlocking {
    log.info("Program starts")
    val deferred: List<Deferred<Int>> = (1..3).map {
        async {
            log.info("Start coroutine $it")
            suspendDelay2()
            delay(3000L * it)
            log.info("Loading $it")
            it
        }
    }
    log.info("Program waiting")
    val sum = deferred.awaitAll().sum()
    log.info("$sum")
}

suspend fun suspendDelay2() = suspendCoroutine<Unit> { continuation ->
    (1..1000_000).forEach { (1..100000).forEach {  } }
    continuation.resume(Unit)
}

suspend fun suspendDelay3_working() = suspendCoroutine<Unit> { continuation ->
    thread {
        (1..100).forEach { (1..100).forEach {  } }
        continuation.resume(Unit)
    }
}

