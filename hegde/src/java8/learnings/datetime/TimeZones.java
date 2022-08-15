package java8.learnings.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZones {

    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        //offset from GMT or UTC
        System.out.println(zonedDateTime.getOffset());

        //list of zones
     //   System.out.println(ZoneId.getAvailableZoneIds());

       // ZoneId.getAvailableZoneIds().stream().forEach(zone -> System.out.println(zone));
        System.out.println( ZoneId.getAvailableZoneIds().size());
    }
}
