import java.util.Scanner;
public class StringDemos {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = console.nextLine();

        // Recall: all indexes start a 0!
        char letter = name.charAt(0);
        System.out.println("The first letter entered was: " + letter);

        // What happens if the letter is not found?
        int location = name.indexOf('a');
        System.out.println("The letter 'a' can be found at index: " + location);

        // Why do we have to subtract 1 here?
        letter = name.charAt(name.length()-1);
        System.out.println("The letter '" + letter + "' is the last letter in the entry.");

        // We generally want to avoid chars. Here's why:
        System.out.println("Shows letter + location -> " + letter + location);
        System.out.println(letter + location + " <- shows letter + location");

        // Here's how to avoid this. Why is "" needed? What does it do?
        String letter_as_str = "" + name.charAt(name.length() - 1);
        System.out.println(letter_as_str + location + "<- shows letter_as_str + location");

        // When Java "adds" two variables with different types, an implicit type conversion occurs (known as casting)
        // String + int/double/char -> converts the int/double/char to a String, then "adds" them (called concatenate)
        // double + int -> converts the int to a double, then adds them
        // int + char -> converts the char to an int! then adds them
        // Why did the order in lines 22 and 23 make a difference?
    }
}
