package pack1

import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

fun main() {
    println("Program starts")
    postItem3("Something_important_to_say")
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
        println("Preparing the post . . .")
        Thread.sleep(2000L)
        completableFuture.complete("token_123")
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
        println("Submitting the post . . .   ---> token=$token, item=$item")
        Thread.sleep(1000L)
        completableFuture.complete(item)
        null
    }

    return completableFuture
}

fun processPost3(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(1000L)
}
