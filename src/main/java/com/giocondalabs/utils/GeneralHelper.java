package com.giocondalabs.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

public final class GeneralHelper {

    public static final String FORMAT_DAY = "dd/MM/yyyy";
    public static final String FORMAT_HOUR = "HH:mm:ss";

    public static boolean validateString(String value){
        return ((value != null) && (!value.trim().isEmpty()));
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        return Pattern.compile(regex).matcher(password).matches();
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,4}$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    public static LocalDate parseDay(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate parseDay(String value) {
        return parseDay(value, FORMAT_DAY);
    }

    public static LocalDate parseDay(String value, String format) {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
    }

    public static LocalTime parseHour(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalTime parseHour(String value) {
        return parseHour(value, FORMAT_HOUR);
    }

    public static LocalTime parseHour(String value, String format) {
        return LocalTime.parse(value, DateTimeFormatter.ofPattern(format));
    }
}
