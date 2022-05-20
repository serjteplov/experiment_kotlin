package pack2

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


fun main() = runBlocking {

    val scope = CoroutineScope(Job())

    val pjob = scope.launch {
        log.info("Program starts")
        (1..3).map {
            launch {
                log.info("Start coroutine $it")
                log.info("Coroutine scope $this")
//                Thread.sleep(1000L * it) ---  В ЭТОМ СЛУЧАЕ ПРИ ОТМЕНЕ pjob КОРУТИНЫ ПРОДОЛЖАТ ВЫПОЛНЕНИЕ, НО СТАНУТ isActive=false
                delay(1000L * it) //    В ЭТОМ СЛУЧАЕ ПРИ ОТМЕНЕ pjob КОРУТИНЫ ЗАВЕРШАТ ВЫПОЛНЕНИЕ
                log.info("Loading $it")
            }
        }.forEach {
            log.info("Job $it, isActive ${it.isActive}")
        }
        log.info("Program waiting")

    }
    delay(1500)
    pjob.cancel()
    delay(2000)
    log.info("FULL STOPPED")

}




