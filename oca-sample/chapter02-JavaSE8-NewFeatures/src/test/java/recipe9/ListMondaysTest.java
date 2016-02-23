package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by O26 on 23/02/2016.
 */
public class ListMondaysTest {

    private ListMondays listMondays;
    private Month month;
    
    @Test
    public void testName() throws Exception {
        System.out.printf("For the month of %s:%n", month);
        LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        Month mi = date.getMonth();
        while (mi == month) {
            System.out.printf("%s%n", date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();
        }
    }

    @Before
    public void setUp() throws Exception {
        listMondays = new ListMondays();
        month = DateTimeUtil.validateMonthValue(listMondays.getMonth());
    }

    @After
    public void tearDown() throws Exception {
        listMondays = null;
    }
}
