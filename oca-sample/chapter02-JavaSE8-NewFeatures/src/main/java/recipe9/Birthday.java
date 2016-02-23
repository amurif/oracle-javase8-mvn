package recipe9;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by O26 on 23/02/2016.
 */
public class Birthday {

    private LocalDate today;
    private LocalDate birthday;
    private LocalDate nextBDay;

    public Birthday(){
        today = LocalDate.now();
        birthday = LocalDate.of(1960, Month.JANUARY, 1);
        nextBDay = birthday.withYear(today.getYear());
    }

    /*
     * Calculate the span of time from today until your birthday, assuming your
     * birthday occured on January 1st. The calculation is done using both
     * months and days (using Period) and days only (using ChronoUnit.between).
     */
    public void oneYearUp(){
        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }
    }

    public LocalDate getToday() {
        return today;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getNextBDay() {
        return nextBDay;
    }
}
