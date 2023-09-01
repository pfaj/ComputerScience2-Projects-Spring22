import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Method: return a list of Integers corresponding to a list of Strings
    public static ArrayList<Integer> convertToInteger(String[] strs) {

        ArrayList<Integer> scores = new ArrayList<Integer>();

        for (String strScore : strs) {
            int score = Integer.parseInt(strScore);
            scores.add(score);
        }

        return scores;
    }


    // Method: compute the average of a list of Integers
    public static double average(ArrayList<Integer> ints) {

        int sum = 0;

        for (int value : ints) {
            sum += value;
        }

        double avg = ((double)sum) / ints.size();
        return avg;
    }


    // Method: report the indexes where the value is above a threshold
    public static ArrayList<Integer> indexesAbove(double threshold, ArrayList<Integer> ints) {

        ArrayList<Integer> indexes = new ArrayList<Integer>();

        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) > threshold) {
                indexes.add(i);
            }
        }

        return indexes;
    }


    // Required main method: Input/Output sequences
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        // Acquire sequence as string and split into list
        System.out.println("Enter the scores, separating each score by a space");
        String input = console.nextLine();
        String[] sequence = input.split(" ");


        // Create corresponding list of ints rather than strings
        ArrayList<Integer> scores = convertToInteger(sequence);


        // Show the scores to ensure the data was properly converted
        System.out.println("Scores confirmation");
        System.out.println("String scores: " + Arrays.toString(sequence));
        System.out.println("   int scores: " + scores);

        // Compute and print the average
        double avg = average(scores);
        System.out.println("Average: " + avg);
        System.out.printf("Rounded: %.2f\n", avg);


        // Determine and print which items are above average
        ArrayList<Integer> above_indexes = indexesAbove(avg, scores);
        System.out.print(above_indexes.size() + " scores above average at indexes: ");
        for (int index : above_indexes) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

}
