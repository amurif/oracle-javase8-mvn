package recipe9;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by O26 on 23/02/2016.
 */
/*
 * This example uses ZonedDateTime to calculate the arrival time of
 * a flight that leaves from San Francisco and arrives in Tokyo.
 * The flight is 10 hours, 50 minutes long. Formatters are used to
 * print the departure and arrival times.
 */
public class Flight {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

    private LocalDateTime leaving;
    private ZoneId leavingZone;
    private ZonedDateTime departure;
    private ZoneId arrivingZone;
    private ZonedDateTime arrival;
    private DateTimeFormatter dateTimeFormatter;

    public Flight() {
        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
        this.leaving = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
        this.leavingZone = ZoneId.of("America/Los_Angeles");
        this.departure = ZonedDateTime.of(leaving, leavingZone);
        // Flight is 10 hours and 50 minutes, or 650 minutes
        this.arrivingZone = ZoneId.of("Asia/Tokyo");
        this.arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(650);
        this.dateTimeFormatter = FORMAT;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public LocalDateTime getLeaving() {
        return leaving;
    }

    public ZoneId getLeavingZone() {
        return leavingZone;
    }

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public ZoneId getArrivingZone() {
        return arrivingZone;
    }

    public ZonedDateTime getArrival() {
        return arrival;
    }
}
