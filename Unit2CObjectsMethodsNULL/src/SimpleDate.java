// models a date between Jan 1 and Dec 31
// using the modern calendar and excludes
// Feb 29 as a possible date

public class SimpleDate {


    // fields //////////

    private int mon;
    private int day;

    private static String[] monthNames = { "Unk", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    private static String[] monthNamesExt = { "nown", "uary", "ruary", "ch", "il", "", "e", "y", "ust", "tember", "ober", "ember", "ember" };
    private static int[] monthDurations = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };


    // constructors

    // Constructs a date of Jan 1
    public SimpleDate() {
        setMonth(1);
        setDay(1);
    }


    // Constructs a date based on input parameters
    public SimpleDate(int monthNum, int dayNum) {
        setMonth(monthNum);
        setDay(dayNum);
    }


    // mutators / setters ////////


    // sets the month num unless not between 1 and 12 inclusive,
    // in which case sets the month to 1
    public void setMonth(int num) {
        if (num >= 1 && num <= 12) {
            mon = num;
        }
        else {
            mon = 1;
        }
    }


    // sets the day in accordance with the current month
    // unless the day is not valid for the current month,
    // in which case sets the day to 1
    public void setDay(int num) {
        if (num < 1 || num > monthDurations[mon]) {
            day = 1;
        }
        else {
            day = num;
        }
    }


    // accessors / getters ///////


    // returns the month as a number
    public int getMonth() {
        return mon;
    }


    // returns the day
    public int getDay() {
        return day;
    }


    // returns the month as a String, either abbreviated
    // or full word based on the input parameter value
    public String getMonthName(boolean abbr) {
        String name = monthNames[mon];

        if (!abbr) {
            name += monthNamesExt[mon];
        }

        return name;
    }


    // returns the number of the date in the calendar year
    // (excludes the possibility of a leap year)
    public int getDayOfYear() {
        int dayOfYear = 0;

        for (int month = 1; month < mon; month++) {
            dayOfYear += monthDurations[month];
        }

        return dayOfYear + day;
    }


    // returns the number of days from this date until
    // the input date (ignoring the possibility of leap year)
    public int getDaysUntil(SimpleDate sd) {
        int myDayOfYear = this.getDayOfYear();
        int sdDayOfYear = sd.getDayOfYear();

        int diff = sdDayOfYear - myDayOfYear;

        if (myDayOfYear > sdDayOfYear) {
            diff += 365;
        }

        return diff;
    }
    

    // returns the number of days in the current month
    public int getDaysInMonth() {
        return monthDurations[mon];
    }


    public boolean equals(SimpleDate sd) {
        return (this.mon == sd.mon && this.day == sd.day);
    }


    @Override
    public String toString() {
        String fmt = "SimpleDate[mon=%d,day=%d]";
        String str = String.format(fmt, mon, day);
        return str;
    }

}
