/*
The foreach loop can be used when you want to visit each element 
in an array in the order from beginning to end. This loop can be 
used only to inspect element values and cannot be used to 
change element values.

Unlike Python, the foreach loop cannot be used to visit 
each of the characters of a String. We'll need to use a 
different loop for that situation.
*/

import java.util.Arrays;
import java.util.Scanner;

public class ForEach {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("Phrase: ");
        String input = console.nextLine();

        String[] phraseWords = input.split(" ");

        System.out.println("phraseWords before:" + Arrays.toString(phraseWords));

        for (String word : phraseWords) {
            System.out.println("word: " + word);

            // this code has no effect on the array
            word = "change";
        }

        System.out.println("phraseWords  after:" + Arrays.toString(phraseWords));

        int[] scores = {8, 6, 7, 5, 3, 0, 9};

        System.out.println("\nscores array:");
        for (int score : scores) {
            System.out.println(score);
        }

        console.close();
    }

}