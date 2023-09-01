import java.util.Scanner;

public class BoolLogicAndSubstring {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("Name your favorite professional athlete: ");
        String person = console.nextLine();

        char someChar = person.charAt(0);
        System.out.println("First   (char): " + someChar);

        String strLetter = person.substring(0, 1);
        System.out.println("First (String): " + strLetter);

        int len = person.length();
        int lastIndex = len - 1;

        someChar = person.charAt(lastIndex);
        System.out.println("Last    (char): " + someChar);

        strLetter = person.substring(lastIndex, len);
        System.out.println("Last  (String): " + strLetter);

        System.out.print("\nIndex: ");
        String input = console.nextLine();
        int i = Integer.parseInt(input);

        strLetter = getLetter(person, i);
        System.out.println("The letter at index " + i + " is " + strLetter);

        console.close();
    }

    public static String getLetter(String s, int index) {
        String letter = "";
        int len = s.length();

        if (index >= 0 && index < len) {
            letter = s.substring(index, index + 1);
        }

        // in Java use && instead of and
        //         use || instead of or
        //         use !  instead of not

        return letter;
    }

}
