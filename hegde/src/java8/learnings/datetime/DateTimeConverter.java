package java8.learnings.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {

    final static String  dateTime = "2022-11-30T14:34:05";
    final static String  dateTime2 = "2022-11-19T14*34*05";
    final static String  dateTime3 = "2022-11-21XYZ14*34*05";

    public static void main(String[] args) {


        parse();
        format();
    }

    private static void parse(){

        System.out.println(LocalDateTime.parse(dateTime));
        System.out.println(LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(LocalDateTime.parse(dateTime2,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH*mm*ss")));
        System.out.println(LocalDateTime.parse(dateTime3,DateTimeFormatter.ofPattern("yyyy-MM-dd'XYZ'HH*mm*ss")));
    }

    private static void format(){

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'XYZ'HH*mm*ss")));
    }
}
