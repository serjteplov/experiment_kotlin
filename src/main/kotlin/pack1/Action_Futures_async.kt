package pack1

import java.util.concurrent.CompletableFuture

fun main() {
    println("Start program")
    postItem4("Something_important_to_say")
    println("End program")
    Thread.sleep(5000L)
}

fun postItem4(item: String) {
    preparePostAsync4()
        .thenComposeAsync { token -> submitPostAsync4(token, item) }
        .thenAcceptAsync { post -> processPost4(post) }
}

fun preparePostAsync4(): CompletableFuture<String> {
    val completableFuture = CompletableFuture<String>()

    println("Preparing the post . . .")
    Thread.sleep(1000L)
    completableFuture.complete("token_123")

    return completableFuture
}

fun submitPostAsync4(
    token: String,
    item: String
): CompletableFuture<String> {
    val completableFuture = CompletableFuture<String>()

    println("Submitting the post . . .   ---> token=$token,, item=$item")
    Thread.sleep(1000L)
    completableFuture.complete(item)

    return completableFuture
}

fun processPost4(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(2000L)
}
