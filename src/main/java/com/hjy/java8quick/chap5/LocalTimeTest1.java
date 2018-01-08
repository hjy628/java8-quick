package com.hjy.java8quick.chap5;

import java.time.LocalTime;

/**
 * Created by hjy on 18-1-8.
 */
public class LocalTimeTest1 {

    public static void main(String[] args) {

        LocalTime rightNow = LocalTime.now();
        LocalTime bedTime = LocalTime.of(22,30);    //或者LocalTime.of(22,30,0)

        LocalTime wakeup = bedTime.plusHours(8);    //早上6点半醒来

        System.out.println(rightNow);
        System.out.println(bedTime);
        System.out.println(wakeup);

    }


}
