package recipe9;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by O26 on 23/02/2016.
 */
/*
 * This program performs two functions:
 *   1. It prints, to standard out, a list of time zone IDs for time zones
 *      that are offset by times other than an hour.
 *   2. It prints a file, called "timeZones", that contains a list of
 *      all time zone IDs.
 */
public class TimeZoneId {


    private Set<String> allZones;
    private List<String> zoneList;
    private LocalDateTime localDateTime;

    public TimeZoneId() {
        allZones = ZoneId.getAvailableZoneIds();
        // Create a List using the set of zones and sort it.
        zoneList = new ArrayList<>(allZones);
        Collections.sort(zoneList);
        localDateTime = LocalDateTime.now();
    }

    public Set<String> getAllZones() {
        return allZones;
    }

    public List<String> getZoneList() {
        return zoneList;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
