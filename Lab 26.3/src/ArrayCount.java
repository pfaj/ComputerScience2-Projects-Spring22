import java.util.Scanner;

public class ArrayCount {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Below, enter the array of values");
        int[] values = getConsoleInputAsIntArray(console);

        System.out.println("Below, enter the number to look for and count.");
        int target = Integer.parseInt(console.nextLine());

        int iterCount = iterativeCount(target, values);
        int recurCount = recursiveCount(target, values);

        System.out.println(" iterCount: " + iterCount);
        System.out.println("recurCount: " + recurCount);
    }

    // counts the number of times that target appears as an element in values
    public static int iterativeCount(int target, int[] values) {
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                count++;
            }
        }

        return count;
    }

    // counts the number of times that target appears as an element in values
    // by making the initial call to recursiveCountFrom
    public static int recursiveCount(int target, int[] values) {

        return recursiveCountFrom(0, target, values);
    }


    // you will implement this method using recursion
    // counts the number of times target appears as an element, between index and the end, in values
    public static int recursiveCountFrom(int index, int target, int[] values) {
        int results = 0;
        if (index >= values.length) {
            return 0;
        } else {
            if (values[index] == target) {
                results += 1;
            }
        }
         int sum = results + recursiveCountFrom(index + 1, target, values);
        return sum;
    }

    public static int[] getConsoleInputAsIntArray(Scanner console) {
        String input = console.nextLine();
        String[] data = input.split(" ");
        int[] nums = new int[data.length];

        int i;
        for (i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(data[i]);
        }

        return nums;
    }
}
