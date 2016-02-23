package recipe9;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * Created by O26 on 23/02/2016.
 */
public class FridayThirteenQuery implements TemporalQuery<Boolean> {
    // Returns TRUE if the date occurs on Friday the 13th.
    public Boolean queryFrom(TemporalAccessor date) {
        return ((date.get(ChronoField.DAY_OF_MONTH) == 13) && (date.get(ChronoField.DAY_OF_WEEK) == 5));
    }
}
