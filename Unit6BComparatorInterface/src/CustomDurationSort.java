import java.util.ArrayList;
import java.util.Comparator;

public class CustomDurationSort {

    public static void main(String[] args) {

        // Part 3b: Custom-sorting lists
        //          - What if only minutes and seconds matter in times?

        ArrayList<Duration> times = new ArrayList<Duration>();
        times.add(new Duration(1, 10, 0));
        times.add(new Duration(1, 40, 0));
        times.add(new Duration(0, 15, 0));
        times.add(new Duration(0, 20, 0));

        System.out.println("times before sort: " + times);
        Comparator<Duration> compDur = minutesSeconds();
        times.sort(compDur);
        System.out.println("times  after sort: " + times);
    }

    public static Comparator<Duration> minutesSeconds() {

        class MinutesSeconds implements Comparator<Duration> {
            @Override
            public int compare(Duration dur1, Duration dur2) {

                // compareTo is not going to help us here, so
                // we're going to use the getters to help us
                // compare the data fields we care about

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

}
