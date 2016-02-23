package recipe8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by O26 on 23/02/2016.
 */
public class RepeatingAnnotationTest {

    private Manufacturer[] manufacturers;

    @Test
    public void testRepeatableAnnotation() {
        manufacturers = Car.class.getAnnotationsByType(Manufacturer.class);
        System.out.println("Number of car manufacturers is " + a.length);

        System.out.println("\n-------Printing out Car Manufacturers--------");

        Cars cars = Car.class.getAnnotation(Cars.class);
        for (Manufacturer car : cars.value()) {
            System.out.println(car.value());
        }
    }

    @Before
    public void setUp() throws Exception {
        manufacturers = Car.class.getAnnotationsByType(Manufacturer.class);
    }

    @After
    public void tearDown() throws Exception {

    }
}