package recipe8;

import java.lang.annotation.Repeatable;

/**
 * Created by O26 on 23/02/2016.
 */
@Repeatable(value = Cars.class)
public @interface Manufacturer {
    String value();
}
