/*
 * Another way that you might establish an array is to call
 * a method that returns an array. The String class split
 * method is an example.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArraysFromStrings {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("Phrase: ");
        String input = console.nextLine();

        String[] words = input.split(" ");

        System.out.println("words: " + Arrays.toString(words));

        String people = "Duke,Elizabeth,Joel,Pratheep,Richard,Ryan,Scott,Shannon";

        String[] names = people.split(",");

        System.out.println("names: " + Arrays.toString(names));

        console.close();
    }
}