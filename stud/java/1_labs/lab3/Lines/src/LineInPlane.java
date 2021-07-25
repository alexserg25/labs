import com.firstname_lastname.java.lesson3.*;

import java.util.*;

public class LineInPlane {
    public static void main(String[] args) {
        LineInPlane lineInPlane = new LineInPlane();
        lineInPlane.startLineInPlane();
    }

    private void startLineInPlane() {

        int maxLenCoordinate = 1000;

        Points operation = new Points();
        HashMap<Integer, Integer> points;
        points = operation.generationPoints(400, maxLenCoordinate);
        System.out.println("Generation points list: " + points);

        Lines lines = new Lines();
        lines.generationLines(500, maxLenCoordinate);

        int x1, x2, y1, y2;

        System.out.println("\nInput coordinates of one line:");
        Scanner input = new Scanner(System.in);
        System.out.print("Input X1 = ");
        x1 = input.nextInt();
        System.out.print("Input Y1 = ");
        y1 = input.nextInt();
        System.out.print("Input X2 = ");
        x2 = input.nextInt();
        System.out.print("Input Y2 = ");
        y2 = input.nextInt();

        lines.addLine(x1, y1, x2, y2);

        lines.checkIntersectionPoint(lines, points);
    }
}
