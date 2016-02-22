package recipe4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by O26 on 22/02/2016.
 */
public class SimpleJavadocTest {

    private SimpleJavadoc simpleJavadoc;
    private BigInteger[] someValues = {BigInteger.TEN, BigInteger.ONE};;

    @Test
    public void testAddNumbers() throws Exception {
        System.out.println(simpleJavadoc.addNumbers(someValues));
    }

    @Before
    public void setUp() throws Exception {
        simpleJavadoc = new SimpleJavadoc();
    }

    @After
    public void tearDown() throws Exception {
        simpleJavadoc = null;
    }
}