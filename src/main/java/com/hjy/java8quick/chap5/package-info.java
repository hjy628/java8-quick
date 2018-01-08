/**
 * Created by hjy on 18-1-8.
 */
package com.hjy.java8quick.chap5;

/**
 * 新的时间和日期API
 *
 * 所有java.time对象都是不可变的
 * 一个瞬间(Instant)是时间线上的一个点(与Date类似)
 * 在Java事件中，每天都是86400秒(即没有闰秒)
 * LocalDateTime没有时区信息
 * TemporalAdjuster的方法可以处理常用的日历计算，例如找到某个月的第一个星期二
 * ZonedDateTime是指时区中的某一个时间点(类似于Gregorian Calendar)
 * 当处理带时区的时间时，请使用时段(Period),而非Duration,以便将夏令时的变化考虑在内
 * 使用DaeTimeFormatter来格式化和解析日期和时间
 *
 */
