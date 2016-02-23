package recipe9;

/**
 * Created by O26 on 23/02/2016.
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * This temporal adjuster assumes that payday occurs on the 15th
 * and the last day of each month. However, if either of those
 * days lands on a weekend, then the previous Friday is used.
 */
public class PaydayAdjuster implements TemporalAdjuster {

    /**
     * The adjustInto method accepts a Temporal instance
     * and returns an adjusted LocalDate. If the passed in
     * parameter is not a LocalDate, then a DateTimeException is thrown.
     */
    public Temporal adjustInto(Temporal input) {
        LocalDate date = LocalDate.from(input);
        int day;
        if (date.getDayOfMonth() < 15) {
            day = 15;
        } else {
            day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        }
        date = date.withDayOfMonth(day);
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return input.with(date);
    }
}