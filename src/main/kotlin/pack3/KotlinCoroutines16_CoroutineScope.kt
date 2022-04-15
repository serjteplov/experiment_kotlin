package pack3

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {


    runBlocking {

        println("runBlocking = ${this}")

        launch {
            println("launch = ${this}")

            launch {
                println("child launch = ${this}")
            }

        }

        async {
            println("async = ${this}")
        }

    }
}

