/*
An array is a sequence of variables, all of the same data type. 
Arrays are similar to lists in Python in that elements are 
stored in an order. Arrays are different from lists in Python 
because each element must be the same data type and because the 
length of an array cannot change. Elements cannot be added to 
an array and elements cannot be removed from an array.
*/
import java.util.Arrays;

public class ArrayIntro {

    public static void main(String[] args) {

        // one way to create an array: literal notation
        String[] names = {"Michael", "Gary", "Scott"};

        // printing an array is a little unusual
        System.out.println("Don't print an array this way: " + names);
        System.out.println("   Do print an array this way: " + Arrays.toString(names));

        // another way to create an array: establish array length only
        int[] scores = new int[7];

        // when created this way, each value is initially zero
        System.out.println("scores at creation: " + Arrays.toString(scores));

        // then assign each value independently
        scores[0] = 4;
        scores[1] = 8;
        scores[2] = 1;
        scores[3] = 5;
        scores[4] = 1;
        scores[5] = 6;
        scores[6] = 2;

        System.out.println("scores after assignment: " + Arrays.toString(scores));
    }

}