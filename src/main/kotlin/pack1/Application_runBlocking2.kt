package pack1

import kotlinx.coroutines.*

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

//      На тредах - гораздо дольше
//        val jobs = List(100_000) {
//            Thread {
//                Thread.sleep(1000)
//                print(".")
//            }
//        }
//        jobs.forEach { it.start() }
}

