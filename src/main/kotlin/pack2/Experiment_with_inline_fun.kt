package pack2


fun main() {
    val positiveResult = concatenate("Hello", "world")
    val negativeResult = concatenate("Hello", 42)
    println("positiveResult = ${positiveResult}")
    println("negativeResult = ${negativeResult}")

    getFirst<Int>()

}



inline fun <reified T1, reified T2> concatenate(arg1: T1, arg2: T2): T1? {
    if (T1::class == String::class && T2::class == String::class) {
        return ((arg1 as String) + (arg2 as String)) as T1
    }
    return null
}

inline fun <reified T> getFirst(): T? {
    if (T::class == String::class) {
        println("Type of T is String")
    }
    return null
}