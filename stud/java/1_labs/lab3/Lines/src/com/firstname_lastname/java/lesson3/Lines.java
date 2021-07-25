package com.firstname_lastname.java.lesson3;

/**
 * Class of operations with lines
 *
 * @version 1.0
 * @author FIO
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lines {
    private ArrayList<Integer> valX1;
    private ArrayList<Integer> valY1;
    private ArrayList<Integer> valX2;
    private ArrayList<Integer> valY2;
    private int linePosition;

    private final String FILE_NAME = "File.txt";

    public Lines() {
        valX1 = new ArrayList<>();
        valY1 = new ArrayList<>();
        valX2 = new ArrayList<>();
        valY2 = new ArrayList<>();

        linePosition = -1;
    }

    public void addLine(int valX1, int valY1, int valX2, int valY2) {
        this.valX1.add(valX1);
        this.valY1.add(valY1);
        this.valX2.add(valX2);
        this.valY2.add(valY2);
    }

    public boolean nextLine() {
        if (valX1.size() > linePosition + 1) {
            linePosition++;
            return true;
        } else {
            return false;
        }
    }

    public void goInBeginning() {
        linePosition = -1;
    }

    public int getCurPosition() {
        return linePosition;
    }

    public int getNumberLines() {
        return valX1.size();
    }

    public void generationLines(int maxCount, int maxLenCoordinate) {
        int x;
        int y;

        for (int i = 0; i < maxCount; i++) {
            x = (int) (Math.random() * maxLenCoordinate);
            y = (int) (Math.random() * maxLenCoordinate);
            this.valX1.add(x);
            this.valY1.add(y);

            x = (int) (Math.random() * maxLenCoordinate);
            y = (int) (Math.random() * maxLenCoordinate);

            this.valX2.add(x);
            this.valY2.add(y);
        }
    }

    public int getX1(){
        int valX = this.valX1.get(linePosition);
        return valX;
    }

    public int getY1() {
        int valY = this.valY1.get(linePosition);
        return valY;
    }

    public int getX2(){
        int valX = this.valX2.get(linePosition);
        return valX;
    }

    public int getY2() {
        int valY = this.valY2.get(linePosition);
        return valY;
    }

    public int getX1(int lineNumber){
        int valX = this.valX1.get(lineNumber);
        return valX;
    }

    public int getY1(int lineNumber) {
        int valY = this.valY1.get(lineNumber);
        return valY;
    }

    public int getX2(int lineNumber){
        int valX = this.valX2.get(lineNumber);
        return valX;
    }

    public int getY2(int lineNumber) {
        int valY = this.valY2.get(lineNumber);
        return valY;
    }

    public void checkIntersectionPoint(Lines lines, HashMap<Integer, Integer> points) {
        int count;
        int x, x1, x2, y, y1, y2;
        double valLeft;
        double valRight;
        String mess = "";
        Set<Integer> keys = points.keySet();
        ArrayList<String> strWrite = new ArrayList<>();

        while (lines.nextLine()) {
            x1 = lines.getX1();
            x2 = lines.getX2();
            y1 = lines.getY1();
            y2 = lines.getY2();
            count = 0;

            for (int key: keys) {
                x = key;
                y = points.get(key);
                valLeft = (double)(x - x1)/(double)(x2 - x1);
                valRight = (double)(y - y1)/(double)(y2 - y1);

                if (valLeft == valRight) {
                    count++;
                }
            }

            if (count > 0) {
                System.out.println("Bingo!!! Count points = " + count);
                mess = "Line coordinate: x1 = "
                        + lines.getX1() + ", y1 = " + lines.getY1()
                        + ", x2 = " + lines.getX2() + ", y2 = " + lines.getY2() + "! ";
                System.out.println(mess);
            }
            if (count > 1) {
                strWrite.add(mess + "Count points = " + count);
            }
        }
        if (!strWrite.isEmpty()) {
            writeToFile(strWrite, FILE_NAME);
        }
    }

    public void writeToFile (ArrayList<String> arrayList, String fileName) {
        try {
            Formatter f = new Formatter(fileName);

            for (String line: arrayList) {
                f.format("%s %s", line, "\r\n");

            }

            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

