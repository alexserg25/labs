import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Spliterator;

public class Java {

    private static void printSum(int... nums) {
        int sum = 0;
        for (int num: nums) sum += num;
        System.out.printf("Count numbers = %d, sum = %d", nums.length, sum);
    }

    public static void main(String[] args) {
        printSum(1, 2, 3, 4, 5, 6, 7);
    }
}
