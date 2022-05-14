package pack2


fun main() {

    val user1 = User("alex", 5)
    val user2 = User("alex", 10)
    val user3 = User("alex", 50)
    val user5 = User("john", 1)
    val user6 = User("john", 2)
    val user7 = User("kate", 222)

    val users = listOf(user1, user2, user3, user5, user6, user7)

    val groupBy2 = users.groupBy(
        keySelector = {it.login},
        valueTransform = {it.contributions}
    ).map { User(it.key, it.value.sum()) }

    val groupBy = users.groupingBy { it.login }
        .reduce{_,a,b -> User(a.login,a.contributions + b.contributions)}
        .values.toList()

    val groupBy4 = users.groupingBy { it.login }
        .fold(listOf<User>()) { accumulator, element -> accumulator + User(element.login, element.contributions+2) }



    println("groupBy = $groupBy")

}

data class User(
    val login: String,
    val contributions: Int
)
