package recipe9;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by O26 on 23/02/2016.
 */
/*
 * Convert LocalDate -> ChronoLocalDate -> String and back.
 */
public class StringConverter {
    LocalDate date;

    public StringConverter() {
        this.date = LocalDate.of(1996, Month.OCTOBER, 29);;
    }

    public LocalDate getDate() {
        return date;
    }
}
