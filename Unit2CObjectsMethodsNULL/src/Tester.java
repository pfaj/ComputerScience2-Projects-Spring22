import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Tester {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // What is the prompt method? Look further in the Tester class
        int month = prompt(console, "Month: ");
        int day = prompt(console, "Day: ");

        // This creates a holiday SimpleDate. Create another SimpleDate for your birthday.
        SimpleDate holiday = new SimpleDate(1,1);
        SimpleDate birthDay = new SimpleDate(8,19);

        // Try the setters on the holiday object. Set to your favorite holiday.
        holiday.setMonth(12);
        holiday.setDay(25);

        // Try the primary getters on your birthday object, confirm the data.
        System.out.println("Birthday month: " + birthDay.getMonth());
        System.out.println("Birthday   day: " + birthDay.getDay());

        // Try to get the name of your birth month using another method/function
        System.out.println("Birthday month name (full): " + birthDay.getMonthName(false));
        System.out.println("Birthday month name (abbr): " + birthDay.getMonthName(true));

        // Print the day of the year for new years and your birthday
        System.out.println("Day of Holiday: " + holiday.getDayOfYear());
        System.out.println("Day of Birthday: " + birthDay.getDayOfYear());

        // For *each* of the objects, get the days until the *other* object
        System.out.println("Days from birthday to holiday: " + birthDay.getDaysUntil(holiday));
        System.out.println("Days from holiday to brithday: " + holiday.getDaysUntil(birthDay));


        // Set the holiday object to have the same month and day as your birthday object
        holiday.setDay(birthDay.getDay());
        holiday.setMonth(birthDay.getMonth());


        // Create another reference to the holiday object
        SimpleDate secondRef = holiday;


        // Review .equals() and == differences
        if(secondRef == holiday){
            System.out.println("secondRef == holiday");
        }
        if(secondRef.equals(holiday)){
            System.out.println("secondRef.equals(holiday)");
        }
        // Try the above, but with your birthday object instead of the holiday object

        


        // Implement the print method - this line of code should be able to test it
        print(holiday);

        // This calls "lastDayOfMonthOf". How can you test that it worked?
        SimpleDate lastDay = lastDayOfMonthOf(holiday);
        print(lastDay);
    }


    // print the abbreviated month name, a space, and the day number
    public static void print(SimpleDate date) {
        System.out.println(date.getMonthName(true) + " " +  date.getDay());
    }


    // return a new object that is the last day of the input's month
    public static SimpleDate lastDayOfMonthOf(SimpleDate date) {
        SimpleDate lastDayOfMonth = new SimpleDate(date.getMonth(), date.getDaysInMonth());
        return lastDayOfMonth; // we will delete this and replace with other code
    }


    // we might use this logic to prompt the user for a number
    // and return that number as an int
    public static int prompt(Scanner console, String message) {
        System.out.print(message);
        String input = console.nextLine();
        int value = Integer.parseInt(input);
        return value;
    }
}
