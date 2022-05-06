package pack1

fun main() {
    println("Program starts")
    postItem("Something_important_to_say")
    println("Program ends")
}

fun postItem(item: String) {
    val token = preparePost()
    val post = submitPost(token, item)
    processPost(post)
}

fun preparePost(): String {
    println("Preparing the post . . .")
    Thread.sleep(2000L)
    return "token_123"
}

fun submitPost(
    token: String,
    item: String
): String {
    println("Submitting the post . . .   ---> token=$token, item=$item")
    Thread.sleep(2000L)
    return item
}

fun processPost(post: String) {
    println("Postprocessing the post . . . Text = $post")
    Thread.sleep(2000L)
}
