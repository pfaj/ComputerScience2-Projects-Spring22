import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileMinMax {

    public static void main(String[] args) {

        // This program will have 2 Scanner objects
        // each Scanner works with different input (console and file)
        // both Scanners will make use of the nextLine() method

        Scanner console = new Scanner(System.in);
        System.out.print("Data source: ");
        String dataSource = console.nextLine();

        Scanner file = getFileScanner(dataSource);

        // establish tracking variables before looping begins
        // in this case, this requires reading the first line of the file
        String person = file.nextLine();

        int countLines = 1;

        String topAlpha = person;
        String bottomAlpha = person;

        int len = person.length();
        int shortest = len;
        int longest = len;

        // read through the file line-by-line
        while (file.hasNextLine()) {
            person = file.nextLine();
            countLines++;

            int comp = person.compareTo(topAlpha);
            if (comp < 0) {
                topAlpha = person;
            }

            comp = person.compareTo(bottomAlpha);
            if (comp > 0) {
                bottomAlpha = person;
            }

            len = person.length();
            if (len < shortest) {
                shortest = len;
            }
            else if (len > longest) {
                longest = len;
            }
        }

        System.out.println("Names range from " + topAlpha + " to " + bottomAlpha);
        System.out.printf("Name lengths range from %d to %d\n", shortest, longest);
        System.out.println(countLines + " total names");

        console.close();
    }


    // this method will be provided to you in all programs for awhile
    // sometime later in our course we will discuss how this works
    public static Scanner getFileScanner(String fileName) {
        try {
            FileInputStream textFileStream = new FileInputStream(fileName);
            Scanner inputFile = new Scanner(textFileStream);
            return inputFile;
        }
        catch (IOException ex) {
            System.out.println("Warning: could not open " + fileName);
            return null;
        }
    }

}