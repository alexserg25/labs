package com.firstname_lastname.java.lesson3;

/**
 * Class file to array operation
 *
 * @version 1.0
 * @author FIO
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class FileArrayOperation {

    public HashMap <Integer, String> getObjectList(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        HashMap<Integer, String> objectList = new HashMap<Integer, String>();
        String[] record;
        int key;
        String value;

        for(String line: lines){
            record = line.split("\\s+");

            if (isCorrectly(record)) {
                key = Integer.parseInt(record[0]);
                value = record[1].trim();

                objectList.put(key, value);
            }
        }
        return objectList;
    }

    private boolean isCorrectly(String[] val) {
        if (val.length != 2) {
            return false;
        }  else if (!isDigit(val[0])) {
            return false
                    ;
        } else {
            return true;
        }
    }

    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public HashMap <Integer, String> sortedObjectList(HashMap <Integer, String> objectList) {
        Map<Integer, String> sort = new TreeMap<>(objectList);
        HashMap<Integer, String> res = new HashMap<>(sort);
        return res;
    }
}
