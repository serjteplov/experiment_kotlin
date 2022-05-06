package pack1

import java.util.concurrent.Executors

fun main() {
    println("Program starts")
    postItem6("Something_important_to_say")
    println("Program ends")
}

fun postItem6(item: String) {
    preparePostAsync6 { token ->
        submitPostAsync6(token, item) { post ->
            processPost6(post)
        }
    }
}

fun preparePostAsync6(callBack: (String) -> Unit) {
    println("Preparing the post . . .")
    Thread.sleep(3000L)

    Executors.newCachedThreadPool().submit<Any?> {
        callBack("token_result")
    }
}

fun submitPostAsync6(
    token: String,
    item: String,
    callBack: (String) -> Unit
) {
    println("Submitting the post . . .   ---> token=$token, item=$item")
    Thread.sleep(1000L)

    Executors.newCachedThreadPool().submit<Any?> {
        callBack("post_result")
    }
}

fun processPost6(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(1000L)
}
