package recipe9;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * Created by O26 on 23/02/2016.
 */
public class FamilyVacations implements TemporalQuery<Boolean> {

    // Returns true if the passed-in date occurs during one of the
    // family vacations. Because the query compares the month and day only,
    // the check succeeds even if the Temporal types are not the same.
    @Override
    public Boolean queryFrom(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        DayOffStatus dayOffStatus = DayOffStatus.getInstance();

        // Disneyland over Spring Break
        if ((month == Month.APRIL.getValue()) && ((day >= 1) && (day <= 10))){
            dayOffStatus.setFamilyVacation(Boolean.TRUE);
            dayOffStatus.setFamilyBirthDay(Boolean.FALSE);
        }

        // Smith family reunion on Lake Saugatuck
        if ((month == Month.JUNE.getValue()) && ((day >= 10) && (day <= 20))){
            dayOffStatus.setFamilyVacation(Boolean.TRUE);
            dayOffStatus.setFamilyBirthDay(Boolean.FALSE);
        }
        return dayOffStatus.isFamilyVacation();
    }
}
