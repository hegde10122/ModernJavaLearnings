package java8.learnings.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConverter {

    public static void main(String[] args) {

        //java.util.date to local date and vice-versa

        Date date = new Date();
        System.out.println(date);


        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(localDate);

        Date date1 = new Date().from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date1);

        //java.sql.date to local date and vice-versa
        java.sql.Date date2 = java.sql.Date.valueOf(localDate);
        System.out.println(date2);

        LocalDate localDate1 = date2.toLocalDate();
        System.out.println(localDate1);

        //Formatter of date
        String date5 = "2022-12-15";
        LocalDate localDate2 = LocalDate.parse(date5, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDate2);

        String date6 = "20221215";
        LocalDate localDate3 = LocalDate.parse(date6, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate3);

        //custom date format
        String date7 = "2052%09%15";
        LocalDate localDate4 = LocalDate.parse(date7, DateTimeFormatter.ofPattern("yyyy%MM%dd"));
        System.out.println(localDate4);
    }
}
