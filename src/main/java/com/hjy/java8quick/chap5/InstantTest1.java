package com.hjy.java8quick.chap5;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

/**
 * Created by hjy on 18-1-8.
 */
public class InstantTest1 {


    public static void main(String[] args) throws Exception{
        Instant start = Instant.now();
        Thread.sleep(new Random().nextInt(100)+50);
        Instant end = Instant.now();

        Duration timeElapsed = Duration.between(start,end);
        long millis = timeElapsed.toMillis();
        System.out.println(millis);

        LocalDate today = LocalDate.now();  //今天的日期

        LocalDate alonzosBirthday = LocalDate.of(1900,8,8);

        alonzosBirthday = LocalDate.of(1900, Month.AUGUST,8);   //使用Month枚举

        LocalDate programmersDay = LocalDate.of(2017,1,1).plusDays(255);    //9月13,如果是闰年则为9月12日
        System.out.println(programmersDay);

        System.out.println(LocalDate.of(2017,1,31).plusMonths(1));
        System.out.println(LocalDate.of(2017,3,31).minusMonths(1));


    }


}
