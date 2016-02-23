package recipe8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by O26 on 23/02/2016.
 */
public class RepeatingAnnotationTest {

    private Manufacturer[] manufacturers;
    private Cars cars;

    @Test
    public void testRepeatableAnnotation() {
        List<String> carList = new ArrayList<>();
        for (Manufacturer car : cars.value()) {
            carList.add(car.value());
        }
        assertNotNull("Car Manufacturers ",cars);
        assertEquals(4, manufacturers.length);
        assertEquals("Mercedes Benz",carList.get(0));
        assertEquals("Toyota",carList.get(1));
        assertEquals("BMW",carList.get(2));
        assertEquals("Range Rover",carList.get(3));
    }

    @Before
    public void setUp() throws Exception {
        manufacturers = Car.class.getAnnotationsByType(Manufacturer.class);
        cars = Car.class.getAnnotation(Cars.class);
    }

    @After
    public void tearDown() throws Exception {
        manufacturers = null;
        cars = null;
    }
}