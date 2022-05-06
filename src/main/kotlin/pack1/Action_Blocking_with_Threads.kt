package pack1

import java.util.concurrent.Executors

fun main() {
    println("Program started")
    postItem7("Something_important_to_say")
    println("Program ended")
}

fun postItem7(item: String) {

    Executors.newCachedThreadPool().submit<Any?> {
        val token = preparePost7()
        val post = submitPost7(token, item)
        processPost7(post)
    }
}

fun preparePost7(): String {
    println("Preparing the post . . .")
    Thread.sleep(2000L)
    return "token_123"
}

fun submitPost7(
    token: String,
    item: String
): String {
    println("Submitting the post . . .   ---> token=$token, item=$item")
    Thread.sleep(2000L)
    return item
}

fun processPost7(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(2000L)
}
