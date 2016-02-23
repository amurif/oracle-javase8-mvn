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

    private Month validateMonthValue(String someMonth){
        Optional<Month> validMonthOptional;
        try {
            validMonthOptional = Optional.of(Month.valueOf(someMonth.toUpperCase()));
        } catch (IllegalArgumentException exc) {
            System.out.printf("%s is not a valid month.%n", someMonth);
            throw exc;    // Rethrow the exception.
        }
        return validMonthOptional.get();
    }

    private LocalDate validateLocalDate(Month someMonth, int someDay){
        Optional<LocalDate> localDateOptional;
        try {
            localDateOptional = Optional.of(LocalDate.of(Year.now().getValue(),someMonth, someDay));
        } catch (DateTimeException exc) {
            System.out.printf("%s %s is not a valid date.%n",someMonth, someDay);
            throw exc;     // Rethrow the exception.
        }
        return localDateOptional.get();
    }

    @Before
    public void setUp() throws Exception {
        Month angieMonth = validateMonthValue("APRIL");
        LocalDate angieDate =  validateLocalDate(angieMonth,3);
        angieBirthday = new FamilyBirthdays(angieMonth,angieDate);

        Month sueMonth = validateMonthValue("JUNE");
        LocalDate sueDate =  validateLocalDate(sueMonth,18);
        sueBirthday = new FamilyBirthdays(sueMonth,sueDate);

        Month joeMonth = validateMonthValue("MAY");
        LocalDate joeDate =  validateLocalDate(joeMonth,29);
        joeBirthday = new FamilyBirthdays(joeMonth,joeDate);
    }


    @After
    public void tearDown() throws Exception {

    }
}