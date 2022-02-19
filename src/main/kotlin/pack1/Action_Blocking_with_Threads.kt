package pack1

import java.util.concurrent.Executors

fun main() {
    postItem7("Something")
    println("Program started")
}

fun postItem7(item: String) {

    Executors.newCachedThreadPool().submit<Any?> {
        val token = preparePost7()
        val post = submitPost7(token, item)
        processPost7(post)
    }
}

fun preparePost7(): String {
    println("Makes request")
    Thread.sleep(2000L)
    return "token result"
}

fun submitPost7(
    token: String,
    item: String
): String {
    println("Submits post: token=$token item=$item")
    Thread.sleep(2000L)
    return "post result"
}

fun processPost7(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(2000L)
}
