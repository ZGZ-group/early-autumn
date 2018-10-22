package com.earlyautumn.ruaiter.config;

import com.earlyautumn.ruaiter.util.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateConverterConfigurer implements Converter<String, Date> {

    //yyyy-MM-dd
    private static final String DEFAULT_DATE_PATTERN = "^\\d{4}-\\d{1,2}-\\d{1,2}$";
    //yyyy-MM-dd HH:mm
    private static final String DEFAULT_DATETIME_PATTERN = "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$";


    @Override
    public Date convert(String date) {

        if (date.matches(DEFAULT_DATE_PATTERN)) {
            return DateUtils.parseDefaultDate(date);
        }

        if (date.matches(DEFAULT_DATETIME_PATTERN)) {
            return DateUtils.parseDefaultDateTime(date);
        }

        throw new IllegalArgumentException("Invalid boolean value '" + date + "'");
    }

}
