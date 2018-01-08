package com.hjy.java8quick.chap5;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * Created by hjy on 18-1-8.
 * DateTimeFormatter提供了三种格式化方法来打印日期/时间
 * 1.预定义的标准格式
 * 2.语言环境相关的格式
 * 3.自定义的格式
 */
public class DateTimeFormatterTest {

    public static void main(String[] args) {
        ZonedDateTime apollolllaunch = ZonedDateTime.of(1969,7,16,9,32,0,0, ZoneId.of("America/New_York"));

        String formatted = DateTimeFormatter.ISO_DATE_TIME.format(apollolllaunch);
        //1969-07-16T09:32:00-04:00[America/New_York]

        formatted = DateTimeFormatter.ISO_DATE_TIME.format(apollolllaunch);
        System.out.println(formatted);


        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);

        String fff = formatter.format(apollolllaunch);

        System.out.println(fff);

        formatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm");

        Instant nowI = Instant.now();

        Date nowD = new Date();

        Date nowId = Date.from(nowI);

        Instant nowDi = nowD.toInstant();

        Timestamp timestamp = Timestamp.from(nowI);






    }


}
