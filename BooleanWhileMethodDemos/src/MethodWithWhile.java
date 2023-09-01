import java.sql.SQLOutput;
import java.util.Scanner;
public class MethodWithWhile {
    // Method #1:
    // Create a method (function) that will continuously ask for user input
    // until they provide input that contains "computer" or "science"
    // and it must include the world "cool"
    // Once they satisfy the requirements, if the word "not" was included,
    // return the string "Incorrect!" otherwise, return "Yeah it is!"
    // Java methods (until after Spring break ;) in this course will always follow this template:
    // public static <return type> <method name>(<input type> <input name>, ...)
    // CONSIDER: what should this method return? What inputs does it need?

    public static void main (String[] args){
        String result = computer();
        System.out.print(result);

        // Call your first method, then feed the returned string into your second method!
    }

    public static String computer(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a string about how cool computer science is: ");
        String phrase = scnr.nextLine();


        while(!((phrase.contains("science") || phrase.contains("computer")) && phrase.contains("cool"))){
            System.out.print("Enter a string about how cool computer science is: ");
            phrase = scnr.nextLine();

        }

        if(phrase.contains("not")){
            return "Incorrect";
        }
        else{
            return "Yeah it is";
        }
    }
    // Method #2:
    // In Java, you may write methods above or below main. Let's write a quick method
    // to take in a String and return nothing. Instead, this method just prints the
    // String provided
}
