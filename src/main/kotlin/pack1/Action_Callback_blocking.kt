package pack1

fun main() {
    println("Program starts")
    postItem2("Something_important_to_say")
    println("Program ends")
}

fun postItem2(item: String) {
    preparePostAsync2 { token ->
        submitPostAsync2(token, item) { post ->
            processPost2(post)
        }
    }
}

fun preparePostAsync2(callBack: (String) -> Unit) {
    println("Preparing the post . . .")
    Thread.sleep(2000L)
    callBack("token_result") // block
}

fun submitPostAsync2(
    token: String,
    item: String,
    callBack: (String) -> Unit
) {
    println("Submitting the post . . .   ---> token=$token, item=$item")
    Thread.sleep(1000L)
    callBack("post_result") // block
}

fun processPost2(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(1000L)
}
