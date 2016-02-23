package recipe1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by O26 on 22/02/2016.
 */
public class HelloMessageTest {

    private HelloMessage helloMessage;

    @Before
    public void setUp() throws Exception {
        helloMessage = new HelloMessage();
    }

    @Test
    public void testHelloMessage() {
        assertEquals("HELLO, WORLD", helloMessage.getMessage());
    }

    @After
    public void tearDown() throws Exception {
        helloMessage = null;
    }

}