package com.firstname_lastname.java.lesson1;

/**
 * Class of operation on arrays
 *
 * @version 1.0
 * @author FIO
 */

public class ArrayOperations {
    public int[] getArrayList(int arraySize) {
        int[] arrayList = new int[arraySize];
        int value = 0;

        for (int i = 0; i < arrayList.length; i++) {
            value = (int) (20 * Math.random() - 10);
            arrayList[i] = value;
        }
        return arrayList;
    }

    public void printArrayList(int[] arrayList) {
        int value;
        System.out.print("Array list: ");

        for (int i = 0; i < arrayList.length; i++) {
            value = arrayList[i];
            if (i == arrayList.length - 1) {
                System.out.println(value + ";");
            } else {
                System.out.print(value + ", ");
            }
        }
    }

    private int getMaxNegativeValue(int[] arrayInt) {
        int minValue = 0;

        for (int value: arrayInt) {
            if ((minValue < value || minValue == 0) && value < 0) {
                minValue = value;
            }
        }
        return minValue;
    }

    public int getMaxNegativePos(int[] arrayInt) {
        int maxNegativePos = -1;
        int maxNegativeVal = getMaxNegativeValue(arrayInt);

        for (int i = 0; i < arrayInt.length; i++) {
            maxNegativePos = (arrayInt[i] >= maxNegativeVal && arrayInt[i] < 0)
                    ? i
                    : maxNegativePos;
        }

        return maxNegativePos;
    }

    private int getMinPositiveValue(int[] arrayInt) {
        int minValue = 0;

        for (int value: arrayInt) {
            if ((minValue > value || minValue == 0) && value > 0) {
                minValue = value;
            }
        }

        return minValue;
    }

    public int getMinPositivePos(int[] arrayInt) {
        int minNegativePos = -1;
        int minNegativeVal = getMinPositiveValue(arrayInt);

        for (int i = 0; i < arrayInt.length; i++) {
            minNegativePos = (arrayInt[i] <= minNegativeVal && arrayInt[i] > 0)
                    ? i
                    : minNegativePos;
        }

        return minNegativePos;
    }

}
