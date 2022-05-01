package pack1

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {
    println("Program starts")
    postItem3("Something")
    println("Program ends")
}

fun postItem3(item: String) {
    preparePostAsync3()
        .thenCompose { token ->
            submitPostAsync3(token, item)
        }
        .thenAccept { post ->
            processPost3(post)
        }
}

fun preparePostAsync3(): CompletableFuture<String> {
    val completableFuture = CompletableFuture<String>()

    Executors.newCachedThreadPool().submit<Any?> {
        println("Makes request")
        Thread.sleep(2000L)
        completableFuture.complete("token result")
        null
    }

    return completableFuture
}

fun submitPostAsync3(
    token: String,
    item: String
): CompletableFuture<String> {

    val completableFuture = CompletableFuture<String>()

    Executors.newCachedThreadPool().submit<Any?> {
        println("Submits post: token=$token item=$item")
        Thread.sleep(1000L)
        completableFuture.complete("post result")
        null
    }

    return completableFuture
}

fun processPost3(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(1000L)
}
