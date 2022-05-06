package pack1

import java.util.concurrent.CompletableFuture

fun main() {
    println("Start program")
    postItem5("Something_important_to_say")
    println("End program")
}

fun postItem5(item: String) {
    preparePostAsync5()
        .thenCompose { token -> submitPostAsync5(token, item) }
        .thenAccept { post -> processPost5(post) }
}

fun preparePostAsync5(): CompletableFuture<String> {
    val completableFuture = CompletableFuture<String>()

    println("Preparing the post . . .")
    Thread.sleep(1000L)
    completableFuture.complete("token_123")

    return completableFuture
}

fun submitPostAsync5(
    token: String,
    item: String
): CompletableFuture<String> {

    val completableFuture = CompletableFuture<String>()


    println("Submitting the post . . .   ---> token=$token, item=$item")
    Thread.sleep(1000L)
    completableFuture.complete(item)


    return completableFuture
}

fun processPost5(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(2000L)
}
