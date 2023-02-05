package com.ricky.read_file.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Component
public class DateTimeFormatUtil {

    public LocalDate stringToLocalDate(String data, String pattern) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(data, parser);
    }

}
