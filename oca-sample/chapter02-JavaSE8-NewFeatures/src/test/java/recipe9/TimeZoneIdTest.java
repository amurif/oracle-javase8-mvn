package recipe9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by O26 on 23/02/2016.
 */
public class TimeZoneIdTest {

    private TimeZoneId timeZoneId;

    @Test
    public void testPrintAllTimeZoneId() throws Exception {

            Path p = Paths.get("timeZones");
            try (BufferedWriter tzfile = Files.newBufferedWriter(p, StandardCharsets.US_ASCII)) {
                for (String s : timeZoneId.getZoneList()) {
                    ZoneId zone = ZoneId.of(s);
                    ZonedDateTime zdt = timeZoneId.getLocalDateTime().atZone(zone);
                    ZoneOffset offset = zdt.getOffset();
                    int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
                    String out = String.format("%35s %10s%n", zone, offset);

                    // Write only time zones that do not have a whole hour offset
                    // to standard out.
                    if (secondsOfHour != 0) {
                        System.out.printf(out);
                    }
                    // Write all time zones to the file.
                    tzfile.write(out);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
    }

    @Before
    public void setUp() throws Exception {
        timeZoneId = new TimeZoneId();
    }

    @After
    public void tearDown() throws Exception {
        timeZoneId = null;
    }
}
