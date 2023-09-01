import java.util.ArrayList;
import java.util.Comparator;

public class CustomStringSort {

    public static void main(String[] args) {

        // Part 3a: Custom-sorting lists
        //          - What if you want names in reverse order?

        ArrayList<String> fac = new ArrayList<>();
        fac.add("Heath");
        fac.add("Pratheep");
        fac.add("Ryan");
        fac.add("Michele");
        fac.add("Scott");
        fac.add("Joel");
        fac.add("Duke");
        fac.add("Shannon");
        fac.add("Elizabeth");

        System.out.println("fac before sort: " + fac);
        Comparator<String> compStr = reverseAlpha();
        fac.sort(compStr);
        System.out.println("fac  after sort: " + fac);
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



    // Step 1: Define a method that returns a Comparator.
    //         The method will usually have an empty input list
    public static Comparator<String> reverseAlphaExplained() {

        // Step 2: Define an inner class that implements Comparator
        //         The name doesn't really matter and you can usually
        //         use the UpperCased version of the method name.
        class ReverseAlpha implements Comparator<String> {

            // Step 3: override the compare method
            @Override
            public int compare(String str1, String str2) {

                // Step 4: Write your logic for comparing the 2 input
                //         objects.  Sometimes this involves calling a
                //         compareTo method for those objects, like here.

                int comp = str2.compareTo(str1);
                return comp;
            }
        }

        // Step 5: create a new object of the class you just defined
        Comparator<String> rev = new ReverseAlpha();

        // Step 6: return the object
        return rev;
    }

}
