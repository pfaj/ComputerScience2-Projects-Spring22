/*
To inspect each individual character of a String a 
foreach loop will not do. Instead, we need a for loop

The for loop in Java looks much, much different 
than in Python. 
 */

import java.util.Scanner;

public class ForLoop {

    public static void main(String[] args) {
        // Below is known as the "traditional" for loop. Most languages started out with notation
        // similar to this. Python typically uses a for each loop (also called an enhanced for loop)
        // The closes to the below loop in Python looks like:
        // for i in range(5):
        //    print(i)
        for (int i = 0; i < 5; i++){
            System.out.println(i);
        }
        System.out.println("\n");

        // The actual mechanics of this loop are:
        // 1) run the code before the first semicolon. In this case, initialize a new integer variable,
        //    "i", with the value 4.
        // 2) evaluate the expression after the first semicolon but before the second. If "true", then enter
        //    the main body of the loop. If "false", then exit the loop.
        // 3) Execute the body of the loop.
        // 4) run the line of code after the second semicolon. In this case, i = i - 1.
        // 5) go to step 2.
        for (int i = 4; i >= 0; i--){
            System.out.println(i);
        }
        System.out.println("\n");

        Scanner console = new Scanner(System.in);
        System.out.print("Word: ");
        String word = console.nextLine();

        for (int i = 0; i < word.length(); i++) {
            String s = word.substring(i, i + 1);
            System.out.println(s + " at index " + i);
        }

        // // we need the code above because the code below does not work            
        // for (String s : word) {
        //    System.out.println(s);
        // }

        // // this doesn't work either
        // for (char s : word) {
        //    System.out.println(s);
        // }

        // but there are times when the above two loops can exist in Java. These are typically
        // used with Arrays, ArrayLists, or other data structures.

        console.close();
    }
}