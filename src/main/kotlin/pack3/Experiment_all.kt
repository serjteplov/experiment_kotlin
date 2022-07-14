package pack3

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


fun main() {

    val usr = Usr("Sergey", 36)
    val mapper = jacksonObjectMapper()
    val asString = mapper.asString(Unit)
    println("asString = $asString")
    println("usr = $usr")
    val usrFromString = mapper.readValue(asString, Usr::class.java)
    println("usrFromString = $usrFromString")

}

fun <T : Any> ObjectMapper.asString(objectClass: T): String {
    return try {
        this.writeValueAsString(objectClass)
    } catch (ex: Exception) {
        throw RuntimeException(ex.cause)
    }
}

data class Usr(
    val name: String,
    val age: Int
)


