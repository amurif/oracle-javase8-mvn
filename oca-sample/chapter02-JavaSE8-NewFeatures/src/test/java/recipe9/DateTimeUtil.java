package recipe9;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by O26 on 23/02/2016.
 */
public class DateTimeUtil {

    private DateTimeUtil(){
        // Do no instantiate this class
    }

    public static int validateYearValue(String someYear) {
        Optional<Integer> validYearOptional;
        try {
            validYearOptional = Optional.of(Integer.valueOf(someYear));
        } catch (IllegalArgumentException exc) {
            System.out.printf("%s is not a valid year.%n", someYear);
            throw exc;    // Rethrow the exception.
        }
        return validYearOptional.get();
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

    public static String toString(LocalDate localDate, Chronology chrono) {
        Optional<String> resultOptional = Optional.empty();
        if (localDate != null) {
            ChronoLocalDate cDate;
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            try {
                cDate = chrono.date(localDate);
            } catch (DateTimeException ex) {
                System.err.println(ex);
                cDate = localDate;
            }
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M/d/yyyy GGGGG");
            resultOptional = Optional.of(dateFormatter.format(cDate));
        }
        return resultOptional.get();
    }

    public static LocalDate fromString(String text, Chronology chrono) {
        Optional<LocalDate> localDateOptional = Optional.empty();
        if (text != null && !text.isEmpty()) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }
            DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().parseLenient()
                    .appendPattern("M/d/yyyy GGGGG")
                    .toFormatter()
                    .withChronology(chrono)
                    .withDecimalStyle(DecimalStyle.of(locale));
            TemporalAccessor temporal = dateTimeFormatter.parse(text);
            ChronoLocalDate cDate = chrono.date(temporal);
            localDateOptional = Optional.of(LocalDate.from(cDate));
        }
        return localDateOptional.get();
    }
}
