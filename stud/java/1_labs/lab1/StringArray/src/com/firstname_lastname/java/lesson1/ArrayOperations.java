package com.firstname_lastname.java.lesson1;

/**
 * Class of operation on arrays
 *
 * @version 1.0
 * @author FIO
 */

public class ArrayOperations {
    public String generationString(int maxLen) {
        String randomString = "";

        if (maxLen < 3) {
            maxLen = 3;
        }

        int len = (int) (Math.random() * maxLen);

        if (len < 2) {
            len = 2;
        }

        //System.out.println((char) (('z' - 'a') * Math.random() + 'a'));
        while (len > randomString.length()) {
            char litera;
            litera = (char) (('z' - 'a') * Math.random() + 'a');
            randomString += litera;
        }

        return randomString;
    }

    public int getMaxIndex(String[] arrayString) {
        String maxValue = arrayString[0];
        int maxIndex = 0;

        for (int i = 1; i < arrayString.length; i++) {
            if (arrayString[i].length() > maxValue.length()) {
                maxValue = arrayString[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public int getMinIndex(String[] arrayString) {
        String minValue = arrayString[0];
        int minIndex = 0;

        for (int i = 1; i < arrayString.length; i++) {
            if (arrayString[i].length() < minValue.length()) {
                minValue = arrayString[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
