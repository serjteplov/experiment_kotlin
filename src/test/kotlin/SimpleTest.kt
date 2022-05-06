import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import pack3.myOwnSuspendingFunction
import kotlin.concurrent.thread

class SimpleTest {

    @Test
    fun myFirstTest() = runBlocking  {

        myOwnSuspendingFunction(100)
        Assert.assertEquals(10, 10)
    }

    @Test
    fun myFirstTest2() {

        val jobs = List(100000) {
            thread {
                Thread.sleep(1000)
                print(".")
            }
        }
        jobs.forEach { it.join() }
    }


}