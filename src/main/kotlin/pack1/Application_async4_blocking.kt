package pack1


fun main() {

    val mess = getMess4()
    val answerPostgres = queryPostgres4()
    val answerGoogle = queryGoogle4()

    mess
    answerPostgres
    answerGoogle

}

fun getMess4(): String {
    println("Entering in getMessage")
    Thread.sleep(1000)
    println("Exiting from getMessage")
    return "Hello"
}

fun queryPostgres4(): String {
    println("Entering in queryPostgres")
    Thread.sleep(2000)
    println("Exiting from queryPostgres")
    return "Postgres done"
}

fun queryGoogle4(): String {
    println("Entering in queryGoogle")
    Thread.sleep(3000)
    println("Exiting from queryGoogle")
    return "Google done"
}


