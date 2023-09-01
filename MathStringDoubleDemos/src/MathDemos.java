import java.util.Scanner;
public class MathDemos {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        String input = console.nextLine();
        int userInt = Integer.parseInt(input);

        System.out.print("Enter a floating-point number: ");
        input = console.nextLine();
        double userDouble = Double.parseDouble(input);

        int progInt = 9;
        double progDouble = 8.675309;

        System.out.println();

        int resultInt = Math.abs(-7);
        System.out.println("Math.abs(-7) returns " + resultInt);

        double resultDouble = Math.abs(-4.9);
        System.out.println("Math.abs(-4.9) returns " + resultDouble + "\n");

        resultInt = Math.max(userInt, progInt);
        System.out.printf("Math.max(%d, %d) returns %d\n", userInt, progInt, resultInt);

        resultDouble = Math.min(userDouble, progDouble);
        System.out.printf("Math.min(%.2f, %.2f) returns %.2f\n\n", userDouble, progDouble, resultDouble);

        // note: this does not work.  Math.pow() always returns a double
        //       even if the inputs are int variables
        // resultInt = Math.pow(userInt, progInt);
        // System.out.printf("Math.pow(%d, %d) returns %d\n", userInt, progInt, resultInt);

        resultDouble = Math.pow(userInt, progInt);
        System.out.printf("Math.pow(%d, %d) returns %.2f\n", userInt, progInt, resultDouble);

        resultDouble = Math.pow(userDouble, progDouble);
        System.out.printf("Math.pow(%.2f, %.2f) returns %.2f\n\n", userDouble, progDouble, resultDouble);

        resultDouble = Math.sqrt(2);
        System.out.println("Math.sqrt(2) returns " + resultDouble);

        resultDouble = Math.sqrt(userDouble);
        System.out.printf("Math.sqrt(%.2f) returns %.2f\n\n", userDouble, resultDouble);

        resultDouble = Math.random();
        System.out.println("This time, Math.random() returned " + resultDouble + "\n");

        System.out.println("Math.PI: " + Math.PI);
        System.out.printf("Math.PI rounded: %.4f\n\n", Math.PI);

    }

}
