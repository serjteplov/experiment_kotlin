package pack1

fun main() {
    postItem2("Something")
    println("Program starting")
}

fun postItem2(item: String) {
    preparePostAsync2 { token ->
        submitPostAsync2(token, item) { post ->
            processPost2(post)
        }
    }
}

fun preparePostAsync2(callBack: (String) -> Unit) {
    println("Makes request")
    Thread.sleep(2000L)
    callBack("token_result") // block
}

fun submitPostAsync2(
    token: String,
    item: String,
    callBack: (String) -> Unit
) {
    println("Submits post: token=$token item=$item")
    Thread.sleep(1000L)
    callBack("post_result") // block
}

fun processPost2(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(1000L)
}
