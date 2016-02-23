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
public class FamilyBirthdaysTest {

    private FamilyBirthdays angieBirthday;
    private FamilyBirthdays sueBirthday;
    private FamilyBirthdays joeBirthday;


    @Test
    public void testIsAngieBirthday() throws Exception {
        assertEquals("APRIL", angieBirthday.getMonth().name());
        assertEquals("APRIL", angieBirthday.getMonth().toString());
        assertEquals("2016-04-03", angieBirthday.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        assertEquals("2016-04-03", angieBirthday.getDate().toString());
    }

    @Test
    public void testIsSueBirthday() throws Exception {
        assertEquals("JUNE", sueBirthday.getMonth().name());
        assertEquals("JUNE", sueBirthday.getMonth().toString());
        assertEquals("2016-06-18", sueBirthday.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        assertEquals("2016-06-18", sueBirthday.getDate().toString());
    }

    @Test
    public void testIsJoeBirthday() throws Exception {
        assertEquals("MAY", joeBirthday.getMonth().name());
        assertEquals("MAY", joeBirthday.getMonth().toString());
        assertEquals("2016-05-29", joeBirthday.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        assertEquals("2016-05-29", joeBirthday.getDate().toString());
    }

    @Before
    public void setUp() throws Exception {
        Month angieMonth = DateTimeUtil.validateMonthValue("APRIL");
        LocalDate angieDate =  DateTimeUtil.validateLocalDate(angieMonth,3);
        angieBirthday = new FamilyBirthdays(angieMonth,angieDate);

        Month sueMonth = DateTimeUtil.validateMonthValue("JUNE");
        LocalDate sueDate =  DateTimeUtil.validateLocalDate(sueMonth,18);
        sueBirthday = new FamilyBirthdays(sueMonth,sueDate);

        Month joeMonth = DateTimeUtil.validateMonthValue("MAY");
        LocalDate joeDate =  DateTimeUtil.validateLocalDate(joeMonth,29);
        joeBirthday = new FamilyBirthdays(joeMonth,joeDate);
    }

    @After
    public void tearDown() throws Exception {
        angieBirthday = null;
        sueBirthday = null;
        joeBirthday = null;
    }
}