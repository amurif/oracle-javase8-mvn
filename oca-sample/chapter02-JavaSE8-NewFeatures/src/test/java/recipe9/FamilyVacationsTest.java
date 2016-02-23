package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by O26 on 23/02/2016.
 */
public class FamilyVacationsTest {

    private static final String SPRING_VACATION = "Disneyland over Spring Break: ";
    private static final String SPRING_VACATION_DATE = "2016-04-05";
    private static final String FAMILY_REUNION = "Smith family reunion on Lake Saugatuck: ";
    private static final String FAMILY_REUNION_DATE = "2016-05-29";

    private List<LocalDate> dates;

    @Test
    public void testQueryWithEnHancedForLoop() throws Exception {
        for (LocalDate date : dates) {
            String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
            // Invoking the query without using a lambda expression.
            date.query(new FamilyVacations());
            // Invoking the query using a lambda expression.
            date.query(FamilyBirthdays::isFamilyBirthday);
            assertFamilyImportantDate(formattedDate,DayOffStatus.getInstance());
        }
    }

    @Test
    public void testQueryWithForEachJavaSE8Loop() throws Exception {
        dates.forEach(date -> {
            String formattedDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
            // Invoking the query without using a lambda expression.
            date.query(new FamilyVacations());
            // Invoking the query using a lambda expression.
            date.query(FamilyBirthdays::isFamilyBirthday);
            assertFamilyImportantDate(formattedDate,DayOffStatus.getInstance());
        });
    }

    private void assertFamilyImportantDate(String formattedDate, DayOffStatus dayOffStatus) {
        if (dayOffStatus.isFamilyVacation()) {
            assertEquals(SPRING_VACATION, SPRING_VACATION_DATE, formattedDate);
        }
        if (dayOffStatus.isFamilyBirthDay()) {
            assertEquals(FAMILY_REUNION, FAMILY_REUNION_DATE, formattedDate);
        }
    }


    @Before
    public void setUp() throws Exception {
        Month springBreakMonth = DateTimeUtil.validateMonthValue("APRIL");
        LocalDate springBreakDate = DateTimeUtil.validateLocalDate(springBreakMonth, 5);

        Month familyReunionMonth = DateTimeUtil.validateMonthValue("MAY");
        LocalDate familyReunionDate = DateTimeUtil.validateLocalDate(familyReunionMonth, 29);

        dates = new ArrayList<>();
        dates.add(springBreakDate);
        dates.add(familyReunionDate);
    }

    @After
    public void tearDown() throws Exception {
        dates = null;
    }

}