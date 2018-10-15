package com.earlyautumn.ruaiter.util;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {

    public static final String DEFAULT_DATE_FORMATTER = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMATTER = "HH:mm:ss";
    public static final String DEFAULT_DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将Date转换为LocalDate
     *
     * @param date Date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return LocalDate.from(zonedDateTime);
    }

    /**
     * 将Date转换为LocalDateTime
     *
     * @param date 日期
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        return LocalDateTime.from(instant.atZone(ZoneId.systemDefault()));
    }

    /**
     * 将LocalDateTime转换为Date
     *
     * @param localDateTime 日期时间
     * @return Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将LocalDate转换为Date
     *
     * @param localDate 日期
     * @return Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取两个日期相差天数
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 相差天数
     */
    public static Long getNumberTwoDates(Date start, Date end) {

//        if (start == null || end == null) {
        //抛出异常
//        }

        LocalDate localDateStart = dateToLocalDate(start);
        LocalDate localDateEnd = dateToLocalDate(end);

        return localDateStart.until(localDateEnd, ChronoUnit.DAYS);

    }

}
