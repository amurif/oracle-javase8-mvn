package recipe7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by O26 on 22/02/2016.
 */
public class PoolCalculatorTest {

    private PoolCalculator calculator;

    @Test
    public void testCalculateVolume() throws Exception {
        calculator.setLength(32);
        calculator.setWidth(16);
        calculator.setMinDepth(4);
        calculator.setMaxDepth(8);
        /*
        * A method reference can now be used to assign the functionality of the calculateVolume() method to a variable.
        * The method reference is assigned to a variable identified as "volume", and then the "volume" variable is
        * passed to the calculateGallons() method.
        */
        Volume volume = calculator::calculateVolume;
        double poolVolume = volume.calculateVolume();
        assertEquals("Volume of the pool is [cubic feet] ",3072.0, volume.calculateVolume(),0.1);
        assertEquals("Gallons in the pool: ",22978.56, calculator.calculateGallons(volume),0.1);
    }

    @Before
    public void setUp() throws Exception {
        calculator = new PoolCalculator();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }
}