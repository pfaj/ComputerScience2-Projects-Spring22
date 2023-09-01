import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class WhileAndFile {

    public static void main(String[] args) {

        // This program will have 2 Scanner objects
        // each Scanner works with different input (console and file)
        // both Scanners will make use of the nextLine() method

        Scanner console = new Scanner(System.in);
        System.out.print("Data source: ");
        String dataSource = console.nextLine();

        Scanner file = getFileScanner(dataSource);

        // establish tracking variables before looping begins
        int countLines = 0;
        int sumChars = 0;

        // read through the file line-by-line
        while (file.hasNextLine()) {
            String person = file.nextLine();
            System.out.println(person);

            countLines++; // increases the count by 1. short for count = count + 1;

            int len = person.length();
            sumChars += len; // increases sum by len.  short for sum = sum + len;
        }

        double avgLen = (double)sumChars / countLines;
        System.out.printf("%d lines %.1f chars per line\n", countLines, avgLen);

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
