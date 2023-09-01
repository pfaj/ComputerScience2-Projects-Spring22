/*
 * In class, we'll take these steps:
 *
 * Discuss the typical iterative definition of power
 * (i.e., a base number raised to an exponent number)
 *
 * Determine a recursive definition of power
 *
 * Convert the recursive definition into code
 *
 * In this problem we restrict ourselves to non-negative
 * numbers and note that mathematically, any base number
 * n raised to the exponent number 0 is defined to be 1,
 * even when the base number is also 0.
 */

import java.util.Scanner;

public class Power {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("base: ");
        int base = Integer.parseInt(console.nextLine());

        if (base < 0) {
            System.out.println("base must be nonnegative, please try again.");
            return;
        }

        System.out.print(" exp: ");
        int exponent = Integer.parseInt(console.nextLine());

        if (exponent < 0) {
            System.out.println("exponent must be nonnegative, please try again.");
            return;
        }

        int recurPower = recursivePower(base, exponent);
        int iterPower = iterativePower(base, exponent);

        System.out.println("recurPower: " + recurPower);
        System.out.println(" iterPower: " + iterPower);
    }


    // we will implement this method using recursion

    public static int recursivePower(int base, int exp) {
        if (exp == 0){
            return  1;
        }
        return base * recursivePower(base,exp - 1);

    }


    // this method is already implemented
    // you should not change the code here
    public static int iterativePower(int base, int exp) {

        int result = 1;
        for (int p = 0; p < exp; p++) {
            result = result * base;
        }

        return result;
    }

}
