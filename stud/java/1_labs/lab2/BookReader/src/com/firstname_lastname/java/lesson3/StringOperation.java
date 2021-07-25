package com.firstname_lastname.java.lesson3;

/**
 * String operation class
 *
 * @version 1.0
 * @author FIO
 */

public class StringOperation {

    public String centerText(String value, int maxLen) {
        String result = value;

        int curLen = value.length();

        if (curLen < maxLen) {
            result = " ".repeat((maxLen - curLen)/2) + value;
        }
        return result;
    }
}
