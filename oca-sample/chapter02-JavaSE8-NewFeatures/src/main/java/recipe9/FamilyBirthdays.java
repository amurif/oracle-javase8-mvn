package recipe9;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/**
 * Created by O26 on 23/02/2016.
 */
public class FamilyBirthdays {

    private Month month;
    private LocalDate date;

    public FamilyBirthdays(Month month, LocalDate date){
        this.month = month;
        this.date = date;
    }
    // Returns true if the passed-in date is the same as one of the
    // family birthdays. Because the query compares the month and day only,
    // the check succeeds even if the Temporal types are not the same.
    public static Boolean isFamilyBirthday(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        Boolean check = Boolean.FALSE;
        // Angie's birthday is on April 3.
        if ((month == Month.APRIL.getValue()) && (day == 3)) {
            check = Boolean.TRUE;
        }

        // Sue's birthday is on June 18.
        if ((month == Month.JUNE.getValue()) && (day == 18)) {
            check =  Boolean.TRUE;
        }

        // Joe's birthday is on May 29.
        if ((month == Month.MAY.getValue()) && (day == 29)) {
            check = Boolean.TRUE;
        }
        return check;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
