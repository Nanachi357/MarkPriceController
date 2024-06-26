package com.example.MarkPriceController.util;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    public static Long convertDateToMillis(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date, DATE_TIME_FORMATTER);
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDateTime convertMillisToLocalDateTime(Long millis) {
        return LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    public static String convertMillisToDate(long millis) {
        LocalDateTime dateTime = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    }

    public static Long convertToTimestamp(String date, String time) {
        if (date == null || date.isEmpty()) {
            return null;
        }

        LocalDate localDate = LocalDate.parse(date);
        LocalTime localTime = (time == null || time.isEmpty()) ? LocalTime.MIDNIGHT : LocalTime.parse(time);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

}