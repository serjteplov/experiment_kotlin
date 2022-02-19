package pack1

import java.util.concurrent.Executors

fun main() {
    postItem6("Something")
    println("Program starting")
}

fun postItem6(item: String) {
    preparePostAsync6 { token ->
        submitPostAsync6(token, item) { post ->
            processPost6(post)
        }
    }
}

fun preparePostAsync6(callBack: (String) -> Unit) {
    println("Makes request")
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
    println("Submits post: token=$token item=$item")
    Thread.sleep(1000L)

    Executors.newCachedThreadPool().submit<Any?> {
        callBack("post_result")
    }
}

fun processPost6(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(1000L)
}
