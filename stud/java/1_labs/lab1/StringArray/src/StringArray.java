import com.firstname_lastname.java.lesson1.ArrayOperations;

import java.util.Scanner;

public class StringArray {
    public static void main(String[] args) {
        StringArray stringArray = new StringArray();
        stringArray.startStringArray();
    }

    private void startStringArray() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int numberStrings = input.nextInt();

        String[] array = new String[numberStrings];
        ArrayOperations arrayOperations = new ArrayOperations();

        // Read new line symbol (\n)
        String inputStr = input.nextLine();

        for (int i = 0; i < numberStrings; i++) {
            System.out.print("Enter string: ");
            inputStr = input.nextLine();

            if (inputStr.isEmpty()) {
                inputStr = arrayOperations.generationString(15);
                System.out.println("Line is not entered, auto generation string: " + inputStr);
            }

            array[i] = inputStr;
        }

        String maxString = array[arrayOperations.getMaxIndex(array)];
        System.out.println("\nMax string : " + maxString + ", length = " + maxString.length());
        String minString = array[arrayOperations.getMinIndex(array)];
        System.out.println("Min string : " + minString + ", length = " + minString.length());

//        for (String str : array){
//            System.out.println("String : " + str + ", length = " + str.length());
//        }
    }
}
