import java.util.Scanner;

public class IntVsDouble {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // integer example
        System.out.print("How many courses are you taking this term? ");
        String input = console.nextLine();
        int courses = Integer.parseInt(input);

        // floating-point example
        System.out.print("Write pi from memory (no more than 12 digits): ");
        input = console.nextLine(); // notice: don't use String here
        double pi = Double.parseDouble(input);

        // Print confirmation statements
        System.out.println("Print 1: Courses " + courses + "\nAfter new line pi: " + pi);

        System.out.printf("Print 2: %d courses and pi is about %.2f", courses, pi);
        System.out.println();

        System.out.printf("Print 3: %d courses and pi is about %.4f\n", courses, pi);

        int progInt = 5;

        int resultInt = courses / progInt;
        System.out.printf("courses / progInt returns %d\n", resultInt);

        double resultDouble = (double)courses / progInt;
        System.out.printf("(double)courses / progInt returns %.2f\n", resultDouble);

        resultDouble = courses / (double)progInt;
        System.out.printf("courses / (double)progInt returns %.2f\n", resultDouble);

        resultDouble = (double)courses / (double)progInt;
        System.out.printf("(double)courses / (double)progInt returns %.2f\n", resultDouble);

        resultDouble = (double)(courses / progInt);
        System.out.printf("(double)(courses / progInt) returns %.2f\n", resultDouble);

        double progDouble = progInt;
        System.out.println("progDouble: " + progDouble);

        resultDouble = courses / progDouble;
        System.out.printf("courses / progDouble returns %.2f\n", resultDouble);
    }

}
