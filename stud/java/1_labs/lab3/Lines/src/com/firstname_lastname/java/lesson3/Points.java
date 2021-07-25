package com.firstname_lastname.java.lesson3;
/**
 * Class of operations with pointers
 *
 * @version 1.0
 * @author FIO
 */

import java.util.HashMap;

public class Points {
    public HashMap<Integer, Integer> generationPoints(int maxCount, int maxLenCoordinate) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int x, y;

        for (int i = 0; i < maxCount; i++) {
            x = (int) (Math.random() * maxLenCoordinate);
            y = (int) (Math.random() * maxLenCoordinate);

            points.put(x, y);
        }

        return points;
    }

}
