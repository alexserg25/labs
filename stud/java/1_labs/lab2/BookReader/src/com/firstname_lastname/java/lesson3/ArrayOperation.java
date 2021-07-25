package com.firstname_lastname.java.lesson3;

/**
 * Arrays operation class
 *
 * @version 1.0
 * @author FIO
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayOperation {

    public ArrayList<String> sortedListString(ArrayList<String> listString) {
        ArrayList<String> result = new ArrayList<>(listString);
        String tmpStr;

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });

        /*
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size() - 1 - i; j++) {
                if (result.get(j).length() > result.get(j + 1).length()) {
                    tmpStr = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, tmpStr);
                }
            }
        }
         */

        return result;
    }

    public int getMaxLen(ArrayList<String> listString) {
        int maxLen = 0;

        for (String str: listString) {
            if (maxLen < str.length()) {
                maxLen = str.length();
            }
        }

        return maxLen;
    }

    public void centerText(ArrayList<String> listString) {
        StringOperation stringOperation = new StringOperation();

        int maxLen = getMaxLen(listString);
        String curStr = "";

        for (int i = 0; i < listString.size(); i++) {
            curStr = stringOperation.centerText(listString.get(i), maxLen);

            listString.set(i, curStr);
        }
    }


    public ArrayList<String> getTableForm(ArrayList<String> listString) {

        StringOperation stringOperation = new StringOperation();
        ArrayList<String> result = new ArrayList<>();

        int maxLenStr = getMaxLen(listString);

        String head1 = "N";
        String head2 = "Sentence";
        String head3 = "Word's count";

        int field1Len = 4;
        int field2Len = maxLenStr + 2;
        int field3Len = head3.length();

        String column1format = "%-" + field1Len + "s";
        String column2format = "%-" + field2Len + "s";
        String column3format = "%" + field3Len + "s";

        String formatData = "|" + column1format + "|" + column2format + "|" + column3format + "|";

        head2 = stringOperation.centerText(head2, maxLenStr);

        String headTable = String.format(formatData, head1, head2, head3);

        String separate1 = "=".repeat(headTable.length());

        String formatSeparate2 = "|" + column1format + "+" + column2format + "+" + column3format + "|";
        String separate2 = String.format(formatSeparate2,
                "-".repeat(field1Len),
                "-".repeat(field2Len),
                "-".repeat(field3Len));

        String formatSeparate3 = "|" + column1format + "+" + column2format + "+" + column3format + "|";
        String separate3 = String.format(formatSeparate3,
                "=".repeat(field1Len),
                "=".repeat(field2Len),
                "=".repeat(field3Len));

        centerText(listString);

        result.add(separate1);
        result.add(headTable);

        String output = "";
        int wordCount = 0;

        for (int i = 0; i < listString.size(); i++) {
            if (i == 0) {
                result.add(separate3);
            } else {
                result.add(separate2);
            }

            wordCount = Arrays.asList(listString.get(i).trim().split("\\s+")).size();

            output = String.format(formatData,
                    i + 1,
                    listString.get(i),
                    wordCount);

            result.add(output);
        }

        result.add(separate1);

        return result;
    }
}
