package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.MinguoChronology;
import java.time.chrono.ThaiBuddhistChronology;

/**
 * Created by O26 on 23/02/2016.
 */
public class StringConverterTest {

    private StringConverter stringConverter;

    @Before
    public void setUp() throws Exception {
        stringConverter = new StringConverter();
    }

    @Test
    public void testStringConverter() throws Exception {
        LocalDate date = stringConverter.getDate();
        System.out.printf("%s%n", DateTimeUtil.toString(date, JapaneseChronology.INSTANCE));
        System.out.printf("%s%n", DateTimeUtil.toString(date, MinguoChronology.INSTANCE));
        System.out.printf("%s%n", DateTimeUtil.toString(date, ThaiBuddhistChronology.INSTANCE));
        System.out.printf("%s%n", DateTimeUtil.toString(date, HijrahChronology.INSTANCE));
        System.out.printf("%s%n", DateTimeUtil.fromString("10/29/0008 H", JapaneseChronology.INSTANCE));
        System.out.printf("%s%n", DateTimeUtil.fromString("10/29/0085 1", MinguoChronology.INSTANCE));
        //System.out.printf("%s%n", DateTimeUtil.fromString("10/29/2539 E.B", ThaiBuddhistChronology.INSTANCE));
        System.out.printf("%s%n", DateTimeUtil.fromString("6/16/1417 1", HijrahChronology.INSTANCE));
    }

    @After
    public void tearDown() throws Exception {
        stringConverter = null;
    }
}
