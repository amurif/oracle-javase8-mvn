package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by O26 on 23/02/2016.
 */
public class PaydayAdjusterTest {

    private LocalDate nextPayday;
    private LocalDate date;

    @Test
    public void testNextPayday() throws Exception {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy MMM d");
        assertEquals("2016 avr. 5", date.format(format));
        assertEquals("2016 avr. 15", nextPayday.format(format));
    }

    @Before
    public void setUp() throws Exception {
        Month someMonth = DateTimeUtil.validateMonthValue("APRIL");
        date = DateTimeUtil.validateLocalDate(someMonth, 5);
        nextPayday = date.with(new PaydayAdjuster());
    }

    @After
    public void tearDown() throws Exception {
        nextPayday = null;
        date = null;
    }

}