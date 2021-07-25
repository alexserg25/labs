package com.firstname_lastname.java.lesson1;
/**
 * Class calculation operation
 *
 * @version 1.0
 * @author FIO
 */

import java.util.Scanner;

public class Calculation {
    public char getOperator(){
        char operator;
        Scanner input = new Scanner(System.in);

        System.out.println("Input operator:");
        System.out.println("\t'+' - for addition");
        System.out.println("\t'-' - for subtraction");
        System.out.println("\t'*' - for multiplication");
        System.out.println("\t'/' - for division");
        System.out.println("\t'0' - for EXIT");

        operator = input.nextLine().charAt(0);

        return operator;
    }

    public double getSum(double valA, double valB){
        double result = valA + valB;
        return result;
    }

    public double getSubtraction(double valA, double valB){
        double result = valA - valB;
        return result;
    }

    public double getMultiplication(double valA, double valB){
        double result = valA * valB;
        return result;
    }

    public double getDivision(double valA, double valB){
        double result = valA / valB;
        return result;
    }
}
