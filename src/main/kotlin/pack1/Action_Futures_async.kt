package pack1

import java.util.concurrent.CompletableFuture

fun main() {
    postItem4("Something")
    println("Start program")
    Thread.sleep(5000L)
}

fun postItem4(item: String) {
    preparePostAsync4()
        .thenComposeAsync { token -> submitPostAsync4(token, item) }
        .thenAcceptAsync { post -> processPost4(post) }
}

fun preparePostAsync4(): CompletableFuture<String> {
    val completableFuture = CompletableFuture<String>()

    println("Makes request")
    Thread.sleep(1000L)
    completableFuture.complete("token result")

    return completableFuture
}

fun submitPostAsync4(
    token: String,
    item: String
): CompletableFuture<String> {

    val completableFuture = CompletableFuture<String>()


    println("Submits post: token=$token item=$item")
    Thread.sleep(1000L)
    completableFuture.complete("post result")


    return completableFuture
}

fun processPost4(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(2000L)
}
