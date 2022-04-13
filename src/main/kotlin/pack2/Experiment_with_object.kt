package pack2


fun main() {

    val someObj = object {
        val field1: String = "fff"
        val field2: Int = 42
    }

    println("someObj = ${someObj.field1}")

    val obj = object : SomeInter {
        override fun receive() {
            TODO("Not yet implemented")
        }

    }
}
