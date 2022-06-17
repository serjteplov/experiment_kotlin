package pack1

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {

//  выполнится оч быстро
    runBlocking {
        val jobs = List(100_000) {
            launch(coroutineContext) {
                delay(1000)
                print(".")
            }
        }
    }

//      На тредах - оч долго
//        val jobs = List(100_000) {
//            thread {
//                Thread.sleep(1000)
//                print(".")
//            }
//        }
//        jobs.forEach { it.start() }
}

