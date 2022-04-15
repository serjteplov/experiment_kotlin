package pack3

import kotlin.concurrent.thread

fun main() {

    // https://www.youtube.com/watch?v=C38lG2wraoo

    println("Start. Thread: ${Thread.currentThread().name}")

    thread {
        println("Fake work start. Thread: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work finished. Thread: ${Thread.currentThread().name}")
    }

    Thread.sleep(2000)

    println("End. Thread: ${Thread.currentThread().name}")

}