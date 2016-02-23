package recipe8;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by O26 on 23/02/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Cars {
    Manufacturer[] value() default {};
}
