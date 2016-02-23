package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by O26 on 23/02/2016.
 */
public class SuperstitiousTest {

    private Superstitious superstitious;
    private LocalDate date;
    @Test
    public void testName() throws Exception {
        String localDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        if ((LocalDate.now().getDayOfMonth() == new Integer(13)) && (LocalDate.now().getDayOfWeek().getValue() == 5)){
            assertTrue(date.query(new FridayThirteenQuery()));
        } else {
            assertFalse(date.query(new FridayThirteenQuery()));
        }
    }

    @Before
    public void setUp() throws Exception {
        superstitious = new Superstitious();
        Month month = DateTimeUtil.validateMonthValue(superstitious.getMonth());
        date = DateTimeUtil.validateLocalDate(month, superstitious.getDay());

    }

    @After
    public void tearDown() throws Exception {
        superstitious = null;
    }
}
