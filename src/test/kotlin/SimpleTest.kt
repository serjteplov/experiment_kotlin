import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import pack3.myOwnSuspendingFunction

class SimpleTest {

    @Test
    fun myFirstTest() = runBlocking  {

        myOwnSuspendingFunction(100)
        Assert.assertEquals(10, 5+5)
    }


}