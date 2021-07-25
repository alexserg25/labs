import com.firstname_lastname.java.lesson1.ArrayOperations;

/**
 * Example class for working with a numeric array.
 *
 * @version 1.0
 * @author FIO
 */

public class MathArray {
    public static void main(String[] args) {
        MathArray mathArray = new MathArray();
        mathArray.startMathArray();

    }

    private void startMathArray() {
        ArrayOperations arrayOper = new ArrayOperations();

        int[] arrayList = arrayOper.getArrayList(20);
        arrayOper.printArrayList(arrayList);

        int maxNegativePos = arrayOper.getMaxNegativePos(arrayList);
        int maxNegativeVal = arrayList[maxNegativePos];
        int minPositivePos = arrayOper.getMinPositivePos(arrayList);
        int minPositiveVal = arrayList[minPositivePos];

        if (maxNegativePos == -1 || minPositivePos == -1) {
            System.out.println("Condition is not satisfied. Exit is program!");
            System.exit(1);
        }

        arrayList[maxNegativePos] = minPositiveVal;
        arrayList[minPositivePos] = maxNegativeVal;

        System.out.println("Max negative value ( position = " + maxNegativePos
                + ", value = " + maxNegativeVal + ")" );
        System.out.println("Min positive value ( position = " + minPositivePos
                + ", value = " + minPositiveVal + ")" );

        arrayOper.printArrayList(arrayList);
    }
}
