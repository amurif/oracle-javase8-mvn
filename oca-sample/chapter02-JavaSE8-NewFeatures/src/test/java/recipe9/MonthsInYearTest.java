package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.DateTimeException;

import java.io.PrintStream;
import java.lang.NumberFormatException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by O26 on 23/02/2016.
 */
public class MonthsInYearTest {

    private MonthsInYear monthsInYear;
    private int year;

    @Test
    public void testMonthsInYear() throws Exception {
        System.out.printf("For the year %d:%n", year);
        List<String> months = new ArrayList<>(12);
        List<Integer> monthLength = new ArrayList<>(12);
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            months.add(month.name());
            monthLength.add(ym.lengthOfMonth());
        }
        final Integer montOf31Days = new Integer(31);
        final Integer montOf30Days = new Integer(30);
        final Integer montOf29Days = new Integer(29);
        final Integer montOf28Days = new Integer(28);

        int index = 0;
        assertEquals("JANUARY", months.get(index));
        assertEquals(montOf31Days, monthLength.get(index));
        assertEquals("FEBRUARY", months.get(++index));
        if (Year.isLeap(year)) {
            assertEquals(montOf29Days, monthLength.get(index));
        } else {
            assertEquals(montOf28Days, monthLength.get(index));
        }
        assertEquals("MARCH", months.get(++index));
        assertEquals(montOf31Days, monthLength.get(index));
        assertEquals("APRIL", months.get(++index));
        assertEquals(montOf30Days, monthLength.get(index));
        assertEquals("MAY", months.get(++index));
        assertEquals(montOf31Days, monthLength.get(index));
        assertEquals("JUNE", months.get(++index));
        assertEquals(montOf30Days, monthLength.get(index));
        assertEquals("JULY", months.get(++index));
        assertEquals(montOf31Days, monthLength.get(index));
        assertEquals("AUGUST", months.get(++index));
        assertEquals(montOf31Days, monthLength.get(index));
        assertEquals("SEPTEMBER", months.get(++index));
        assertEquals(montOf30Days, monthLength.get(index));
        assertEquals("OCTOBER", months.get(++index));
        assertEquals(montOf31Days, monthLength.get(index));
        assertEquals("NOVEMBER", months.get(++index));
        assertEquals(montOf30Days, monthLength.get(index));
        assertEquals("DECEMBER", months.get(++index));
        assertEquals(montOf31Days, monthLength.get(index));
    }

    @Before
    public void setUp() throws Exception {
        monthsInYear = new MonthsInYear();
        year = DateTimeUtil.validateYearValue(monthsInYear.getYear());
    }

    @After
    public void tearDown() throws Exception {
        monthsInYear = null;
    }
}
