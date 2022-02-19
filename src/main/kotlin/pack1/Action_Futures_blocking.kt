package pack1

import java.util.concurrent.CompletableFuture

fun main() {
    postItem5("Something")
    println("Start program")
}

fun postItem5(item: String) {
    preparePostAsync5()
        .thenCompose { token -> submitPostAsync5(token, item) }
        .thenAccept { post -> processPost5(post) }
}

fun preparePostAsync5(): CompletableFuture<String> {
    val completableFuture = CompletableFuture<String>()

    println("Makes request")
    Thread.sleep(1000L)
    completableFuture.complete("token result")

    return completableFuture
}

fun submitPostAsync5(
    token: String,
    item: String
): CompletableFuture<String> {

    val completableFuture = CompletableFuture<String>()


    println("Submits post: token=$token item=$item")
    Thread.sleep(1000L)
    completableFuture.complete("post result")


    return completableFuture
}

fun processPost5(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(2000L)
}
