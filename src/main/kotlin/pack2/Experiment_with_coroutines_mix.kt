package pack2

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {

    log.info("Before")
    log.info(this.coroutineContext.toString())

    val context = Job() + Dispatchers.Default
    val coroutineScope = CoroutineScope(context)

    val job = coroutineScope.launch {
        log.info("coroutine, start")
        var x = 0
        while (x < 50000000) {
            log.info("coroutine, ${x++} $isActive")
        }
        log.info("coroutine, end")
    }

    Thread.sleep(10)
    log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
//    job.cancel()
    Thread.sleep(1000)




}
