package com.hjy.java8quick.chap5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by hjy on 18-1-8.
 */
public class TemporalAdjusterTest {

    public static void main(String[] args) {

        LocalDate firstTuesday = LocalDate.of(2018,1,1).with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
        System.out.println(firstTuesday);

/*        TemporalAdjuster NEXT_WORKDAY = w->{
            LocalDate result = (LocalDate) w;
            do {
                result = result.plusDays(1);
            }while (result.getDayOfWeek().getValue()>=6);
            return result;
        };*/

        TemporalAdjuster NEXT_WORKDAY = TemporalAdjusters.ofDateAdjuster( w->{
            LocalDate result =  w;  //不需要进行转换
            do {
                result = result.plusDays(1);
            }while (result.getDayOfWeek().getValue()>=6);
            return result;
        });

        LocalDate today = LocalDate.now();
        LocalDate backToWork = today.with(NEXT_WORKDAY);
        System.out.println(backToWork);


    }


    /**
     * next(weekday),previous(weekday) 指定工作日的前一天或后一天
     * nextOrSame(weekday),previousOrSame(weekday) 从指定的日期开始，指定工作日的前一天货后一天
     * dayOfWeekInMonth(n,weekday) 某月中的第n个工作日(weekday所指定)
     * lastInMonth(weekday) 某月中的最后一个工作日(weekday所指定)
     * firstDayOfMonth(),......方法名所描述的日期
     *
     */

}
