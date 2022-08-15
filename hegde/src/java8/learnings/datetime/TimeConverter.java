package java8.learnings.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {

    public static void main(String[] args) {

        String time ="14:45";
        LocalTime localTime =  LocalTime.parse(time);
        System.out.println(localTime);

        System.out.println(LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME));

        //custom defined format---
        String time1 = "15*^05";

        System.out.println(LocalTime.parse(time1,DateTimeFormatter.ofPattern("HH*^mm")));

        String time3 = "13**03**55";

        System.out.println(LocalTime.parse(time3,DateTimeFormatter.ofPattern("HH**mm**ss")));

        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH**mm**ss")));
    }
}
