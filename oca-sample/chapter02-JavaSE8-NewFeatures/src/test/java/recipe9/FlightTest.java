package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

/**
 * Created by O26 on 23/02/2016.
 */
public class FlightTest {

    private Flight flight;


    @Test
    public void testDeparture() {
        String departure = validateZonedDateTime(flight.getDeparture());
        assertEquals("juil. 20 2013  07:30 PM",departure);
        assertEquals("2013-07-20T19:30", flight.getLeaving().toString());
    }

    @Test
    public void testArrival(){
        String arrival = validateZonedDateTime(flight.getArrival());
        assertEquals("juil. 21 2013  10:20 PM",arrival);
        assertEquals("Asia/Tokyo",flight.getArrivingZone().toString());
    }

    @Test
    public void testDaylightSavings(){
        Instant instant = flight.getArrival().toInstant();
        boolean daylightSavings = flight.getArrivingZone().getRules().isDaylightSavings(instant);
        if(daylightSavings){
            assertTrue(daylightSavings);
        } else {
            assertFalse(daylightSavings);
        }
    }

    private String validateZonedDateTime(ZonedDateTime zonedDateTime) {
        String validateZonedDateTime = null;
        try {
            validateZonedDateTime = zonedDateTime.format(flight.getDateTimeFormatter());
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", zonedDateTime);
            throw exc;
        }
        return validateZonedDateTime;
    }

    @Before
    public void setUp() throws Exception {
        flight = new Flight();
    }

    @After
    public void tearDown() throws Exception {
        flight = null;
    }
}