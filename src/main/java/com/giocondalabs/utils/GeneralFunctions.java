package com.giocondalabs.utils;

import java.util.Random;
import java.util.regex.Pattern;

public final class GeneralFunctions {

    public static String randomPassword(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()~";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }

    public static String convertIdToString(Long id) {
        String representation = id.toString();
        int length = 6;

        StringBuilder result = new StringBuilder(randomPassword(length));
        for (int i = 0; i < representation.length(); i++) {
            result
                .append(representation.charAt(i))
                .append(randomPassword(length));
        }

        return result.toString();
    }

    public static Long convertStringToId(String representation) {
        boolean flag = true;
        representation = representation.trim();
        StringBuilder temp = new StringBuilder();

        while (flag) {
            representation = representation.substring(6);
            temp.append(representation.charAt(0));
            representation = representation.substring(1);
            if (representation.length() <= 6) {
                flag = false;
            }
        }

        return Long.parseLong(temp.toString());
    }
}
