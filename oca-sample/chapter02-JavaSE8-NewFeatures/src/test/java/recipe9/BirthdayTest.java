package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Period;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

/**
 * Created by O26 on 23/02/2016.
 */
public class BirthdayTest {

    private Birthday birthday;
    private Period period;
    private long numberOfDay;

    @Test
    public void testOneYearUp() throws Exception {
        assertEquals("Monts: ", -1, period.getMonths());
        assertEquals("Days: ", -22, period.getDays());
        assertEquals("Total: ", -53, numberOfDay);
        System.out.println("There are " + period.getMonths() +
                " months, and " + period.getDays() +
                " days until your next birthday. (" + numberOfDay + " total)");
    }

    @Before
    public void setUp() throws Exception {
        birthday = new Birthday();
        period = Period.between(birthday.getToday(), birthday.getNextBDay());
        numberOfDay = ChronoUnit.DAYS.between(birthday.getToday(), birthday.getNextBDay());
    }

    @After
    public void tearDown() throws Exception {
        period = null;
        numberOfDay = 0L;
        birthday = null;
    }
}