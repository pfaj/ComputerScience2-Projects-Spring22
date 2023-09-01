import java.util.Scanner;

public class IfElseWithStrings {    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("What's your word or phrase? ");
        String phrase = console.nextLine();

        System.out.print("  What are you looking for? ");
        String target = console.nextLine();

        // nested if
        if (phrase.contains(target)) {
            System.out.println("Found it! :-)");
            // What happens if word and target are exactly the same?
            // How could we change this to ONLY show "Exact match" if these are exactly the same?
            if (phrase.startsWith(target)) {
                System.out.println("At the beginning");
            }
            if (phrase.endsWith(target)) {
                System.out.println("At the end");
            }
            if (phrase.equals(target)) {
                System.out.println("Exact match");
            }
        }
        else {
            System.out.println("Did not find it :-(");
        }
        console.close();
    }
}