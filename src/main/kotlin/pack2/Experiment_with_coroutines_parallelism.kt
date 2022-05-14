package pack2

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlinx.coroutines.launch
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

val log: Logger = LoggerFactory.getLogger("Contributors")

// ЕСЛИ указана задержка pureDelay() или notSuspendDelay(), то корутины не запустятся параллельно.
// Произойдет следующее:
// Напечатается Program starts
// Напечатается Program waiting
// Родительская корутина станет suspended
// Это освободит тред для другой корутины
// В этом же треде запустится первая корутина (т.к. мы не указали Dispatchers в async)
// Напечатается Start coroutine 1
// А дальше эта первая корутина продолжит выполнение в текущем треде, занимая его под себя
// тем самым не давая даже запуститься другим корутинам
// Мы не увидим в логах что две другие корутины стартонули
// Это продлится до тех пор пока эта первая корутина не станет suspended
// Но так как у нас есть тяжелое вычисление pureDelay() которое НЕ саспендит первую корутину
// Эта блокировка будет продолжаться
// Такое поведение возникает из-за правила: В одном треде может выполняться только одна корутина
// Чтобы начала выполняться другая корутина, первая должна перейти в состояние suspended
// Вот почему разработчики котлина просят оборачивать все тяжеловесные
// операции в корутины (suspendDelay) или suspend функции (suspendDelayAnother)
// В итоге, чтобы исправить ситуации, надо на 32 строке заменить pureDelay() на suspendDelay() или suspendDelayAnother()
// И тогда все три корутины запустятся "параллельно" и мы увидим это в консоле
// Обрати внимание на функцию notSuspendDelay() которая ведёт себя как pureDelay() не смотря на то что саспендит текущую
// корутину

fun main() = runBlocking {
    log.info("Program starts")
    val deferreds: List<Deferred<Int>> = (1..3).map {
        async {
            log.info("Start coroutine $it")
            pureDelay()
            delay(3000L * it)
            log.info("Loading $it")
            it
        }
    }
    log.info("Program waiting")
    val sum = deferreds.awaitAll().sum()
    log.info("$sum")
}

fun pureDelay() {
    (1..1000_000).forEach { (1..100000).forEach {  } }
}

suspend fun notSuspendDelay() = suspendCoroutine<Unit> { continuation ->
    (1..100).forEach { (1..100).forEach {  } }
    continuation.resume(Unit)
}

suspend fun suspendDelay() = coroutineScope {
    launch {
        (1..1000_000).forEach { (1..100000).forEach {  } }
    }
}

suspend fun suspendDelayAnother() = suspendCoroutine<Unit> { continuation ->
    thread {
        (1..100).forEach { (1..100).forEach {  } }
        continuation.resume(Unit)
    }
}
