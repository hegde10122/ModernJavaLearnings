package java8.learnings.datetime;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTime {

    public static void main(String[] args) {


        //1----local date
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //2 --- local time
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //3 --- local date time
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //4 --- another local date version
        LocalDate localDate1 = LocalDate.of(2022,8,16);
        System.out.println(localDate1);

        //5 ---
        System.out.println(localDate.getMonth()); //get month
        System.out.println(localDate.getDayOfMonth()); //day of month
        System.out.println(localDate.getDayOfYear()); //day of year
        System.out.println(localDate.getDayOfWeek()); //day of week

        //change year to 2023
        System.out.println(localDate.with(ChronoField.YEAR,2023));

        //reduce number of years by 5
        System.out.println(localDate.minus(5, ChronoUnit.YEARS));

        //check for leap year
        System.out.println(localDate.isLeapYear());

        //TIME ---
        LocalTime localTime1 = LocalTime.of(12,23,33,0);
        System.out.println(localTime1);

        //change time to seconds
        System.out.println(localTime1.toSecondOfDay());

        System.out.println(localTime.minusNanos(localTime.getNano()));

        //PERIOD --- use case
        //use case ---- difference between two dates
        Period period = Period.between(localDate ,localDate1);
        System.out.println(period.getMonths());

        //INSTANT --- seconds between now and Jan 1,1970
        System.out.println(Instant.now().getEpochSecond());

    }
}
