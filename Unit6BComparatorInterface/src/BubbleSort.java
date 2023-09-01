import java.util.ArrayList;
import java.util.Comparator;

public class BubbleSort {

    public static void main(String[] args) {

        // Part 4 (if time permits and students are interested)
        // Use the bubbleSort method and the debugger to watch
        // how the compare method can help to sort any list

        ArrayList<String> fac = new ArrayList<>();
        fac.add("Richard");
        fac.add("Pratheep");
        fac.add("Ryan");
        fac.add("Scott");
        fac.add("Joel");
        fac.add("Duke");
        fac.add("Shannon");
        fac.add("Elizabeth");

        Comparator<String> compStr = reverseAlpha();
        bubbleSort(fac, compStr);
        System.out.println("fac  after sort: " + fac);


        ArrayList<Duration> times = new ArrayList<Duration>();
        times.add(new Duration(1, 10, 0));
        times.add(new Duration(1, 40, 0));
        times.add(new Duration(0, 15, 0));
        times.add(new Duration(0, 20, 0));

        Comparator<Duration> compDur = minutesSeconds();
        bubbleSort(times, compDur);
        System.out.println("times  after sort: " + times);
    }

    public static Comparator<String> reverseAlpha() {
        class ReverseAlpha implements Comparator<String> {
            @Override
            public int compare(String str1, String str2) {
                int comp = str2.compareTo(str1);
                return comp;
            }
        }
        Comparator<String> rev = new ReverseAlpha();
        return rev;
    }

    public static Comparator<Duration> minutesSeconds() {
        class MinutesSeconds implements Comparator<Duration> {
            @Override
            public int compare(Duration dur1, Duration dur2) {
                int field1 = dur1.getMinutes();
                int field2 = dur2.getMinutes();
                int comp = Integer.compare(field1, field2);
                if (comp != 0) {
                    return comp;
                }
                field1 = dur1.getSeconds();
                field2 = dur2.getSeconds();
                comp = Integer.compare(field1, field2);
                return comp;
            }
        }
        Comparator<Duration> ms = new MinutesSeconds();
        return ms;
    }


    public static void bubbleSort(ArrayList list, Comparator comp) {
        if (list == null || list.size() < 2) {
            return;
        }

        int countSwaps = -1;
        while (countSwaps != 0) {
            countSwaps = 0;
            Object left = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                Object right = list.get(i);
                int comparison = comp.compare(left, right);
                if (comparison > 0) {
                    list.set(i - 1, right);
                    list.set(i, left);
                    countSwaps++;
                }
                left = right;
            }
        }
    }


    public static void bubbleSortExplained(ArrayList list, Comparator comp) {

        // the bubble sort
        // 1. examine each pair of adjacent elements
        // 2. whenever any pair is out of order, swap them
        // 3. repeat until list is sorted, which we know happens
        //    when, in step #1, we never execute step #2
        //
        // it's called "bubble" sort because the "big" items
        // "bubble up" to the top

        // first make sure the list has at least 2 elements
        if (list == null || list.size() < 2) {
            return;
        }

        int countSwaps = -1;

        // repeat until the list is sorted, i.e., there are no swaps
        while (countSwaps != 0) {

            // get ready to examine each pair by:
            // - resetting the swap count
            // - initializing the first "left" object
            countSwaps = 0;
            Object left = list.get(0);

            // now examine each pair of adjacent elements
            for (int i = 1; i < list.size(); i++) {

                // the "left" side of the pair is set
                // now get the "right" side of the pair
                Object right = list.get(i);

                // compare the elements in the pair
                int comparison = comp.compare(left, right);

                // check if the pair is out of order, using the definition
                // of the value returned by the comp.compare(a, b) method
                if (comparison > 0) {

                    // swap if so, and increase the swap count
                    list.set(i - 1, right);
                    list.set(i, left);
                    countSwaps++;
                }

                // get ready for the next pair of elements
                left = right;
            }
        }

    }

}
