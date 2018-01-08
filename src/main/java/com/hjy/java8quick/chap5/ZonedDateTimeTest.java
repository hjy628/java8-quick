package com.hjy.java8quick.chap5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by hjy on 18-1-8.
 */
public class ZonedDateTimeTest {

    public static void main(String[] args) {


        ZonedDateTime apollolllaunch = ZonedDateTime.of(1969,7,16,9,32,0,0, ZoneId.of("America/New_York"));
        System.out.println(apollolllaunch);


        ZonedDateTime skipped = ZonedDateTime.of(
                LocalDate.of(2013,3,31),
                LocalTime.of(2,30),
                ZoneId.of("Europe/Berlin")
        );
        //创建3月31日3:30
        System.out.println(skipped);

        ZonedDateTime ambiguous = ZonedDateTime.of(
                LocalDate.of(2013,10,27),   //夏令时结束时间
                LocalTime.of(2,30),
                ZoneId.of("Europe/Berlin")
        );
        //2013-10-27T02:30+02:00[Europe/Berlin]

        ZonedDateTime anHourLater = ambiguous.plusHours(1);

        System.out.println(ambiguous);
        System.out.println(anHourLater);

        //2013-10-27T02:30+01:00[Europe/Berlin]


    }


}
