/*
 * In class we will discuss the general concept of
 * recursion through the example of summing the
 * elements of a list, then transition to writing
 * code to recursively compute the sum of elements
 * in an array.
 */

import java.util.Scanner;

public class ArraySumFrom {

    public static void main(String[] args) {
        int[] values = handleInput();
        int recurSum = recursiveArraySum(values);
        int iterSum = iterativeArraySum(values);

        System.out.println("recurSum: " + recurSum);
        System.out.println(" iterSum: " + iterSum);
    }


    // "launcher" or "starter" method: this method is called to initiate
    // the recursive process.  The sum of the entire array is the sum
    // of the numbers from index 0 to the end.
    //
    // launcher methods are commonly used in array-based recursion, but
    // are less common in recursive mathematical computations.
    public static int recursiveArraySum(int[] nums) {

        return recursiveArraySumFrom( 0, nums); // we'll replace this dummy return statement in class
    }

    // recursive method to compute the sum of the elements in nums
    // from index and the end of the array
    public static int recursiveArraySumFrom(int index, int[] nums) {

        if(index >= nums.length){
            return 0;
        }
        // in recursive code, we must address the base case *first*

        // the smallest version of the problem: the index is at or past
        // the very end of the array.  The sum of no numbers at all is 0.


        // now we can write the self-referential part of the solution
        int sum = recursiveArraySumFrom(index + 1, nums);

        // the sum of nums from index to the end of the array is
        // - the sum of nums from (index+1) to the end of the array
        // - *plus* the value at index


        return nums[index] + sum; // we'll replace this dummy return statement in class
    }


    // the launcher method for an interative approach looks the same
    public static int iterativeArraySum(int[] nums) {
        int startingIndex = 0;
        int sum = iterativeArraySumFrom(startingIndex, nums);
        return sum;
    }


    // this is the iterative approach to computing the sum of elements
    // from index to the end of the array.  You've seen and written
    // code like this many times before.
    public static int iterativeArraySumFrom(int index, int[] nums) {

        int sum = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }


    public static int[] handleInput() {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter a sequence of numbers below, separated by spaces.");
        String input = console.nextLine();
        String[] data = input.split(" ");

        int[] result = new int[data.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(data[i]);
        }

        return result;
    }
}
