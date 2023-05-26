package ee.valiit.events.domain.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static LocalTime getLocalTimeFromString(String timeString) {

        // Create a DateTimeFormatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse the string using the formatter to obtain a LocalTime object
        LocalTime localTime = LocalTime.parse(timeString, formatter);

        return localTime;
    }
    public static String getStringFromLocalTime(LocalTime localTime) {

        // Create a DateTimeFormatter for the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Format the LocalTime object to a string using the formatter
        String timeString = localTime.format(formatter);

        return timeString;
    }
}
