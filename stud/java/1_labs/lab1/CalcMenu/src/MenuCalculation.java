import com.firstname_lastname.java.lesson1.Calculation;

import java.util.Scanner;

public class MenuCalculation {
    public static void main(String[] args) {
        MenuCalculation menuCalculation = new MenuCalculation();
        menuCalculation.startMenuCalculation();
    }

    private void startMenuCalculation() {
        Scanner input = new Scanner(System.in);
        boolean isExit = false;
        Calculation calc = new Calculation();
        char operator;

        System.out.print("Enter A: ");
        double valA = input.nextDouble();
        System.out.print("Enter B:");
        double valB = input.nextDouble();

        do {
            operator = calc.getOperator();
            switch (operator) {
                case '+':
                    System.out.println("Sum = " + calc.getSum(valA, valB));
                    break;
                case '-':
                    System.out.println("Subtraction = " + calc.getSubtraction(valA, valB));
                    break;
                case '*':
                    System.out.println("Multiplication = " + calc.getMultiplication(valA, valB));
                    break;
                case '/':
                    System.out.println("Division = " + calc.getDivision(valA, valB));
                    break;
                case '0':
                    isExit = true;
                    break;
            }
        } while(!isExit);
    }
}
