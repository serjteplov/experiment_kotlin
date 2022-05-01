package pack1

fun main() {
    println("Program starts")
    postItem("Something")
    println("Program ends")
}

fun postItem(item: String) {
    val token = preparePost()
    val post = submitPost(token, item)
    processPost(post)
}

fun preparePost(): String {
    println("Makes request")
    Thread.sleep(2000L)
    return "token result"
}

fun submitPost(
    token: String,
    item: String
): String {
    println("Submits post: token=$token item=$item")
    Thread.sleep(2000L)
    return "post result"
}

fun processPost(post: String) {
    println("Postprocessing post: $post")
    Thread.sleep(2000L)
}
