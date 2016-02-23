package recipe9;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Optional;

/**
 * Created by O26 on 23/02/2016.
 */
public class DateTimeUtil {

    private DateTimeUtil(){
        // Do no instantiate this class
    }

    public static Month validateMonthValue(String someMonth) {
        Optional<Month> validMonthOptional;
        try {
            validMonthOptional = Optional.of(Month.valueOf(someMonth.toUpperCase()));
        } catch (IllegalArgumentException exc) {
            System.out.printf("%s is not a valid month.%n", someMonth);
            throw exc;    // Rethrow the exception.
        }
        return validMonthOptional.get();
    }

    public static LocalDate validateLocalDate(Month someMonth, int someDay) {
        Optional<LocalDate> localDateOptional;
        try {
            localDateOptional = Optional.of(LocalDate.of(Year.now().getValue(),someMonth, someDay));
            //localDateOptional = Optional.of(Year.now().atMonth(someMonth).atDay(someDay));
        } catch (DateTimeException exc) {
            System.out.printf("%s %s is not a valid date.%n", someMonth, someDay);
            throw exc;     // Rethrow the exception.
        }
        return localDateOptional.get();
    }
}
