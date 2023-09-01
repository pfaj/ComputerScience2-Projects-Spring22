// Models a duration of time greater than
// or equal to 0 hours, 0 minutes, 0 seconds

// ignore this part, this is
// needed for sorting and will
// be explained in 2 weeks
public class Duration       implements Comparable<Duration> {


    // PLEASE NOTE: the design of some aspects of this class
    // are simplified in order to help illustrate core class
    // concepts as we learn about implementing classes.  We
    // might make different design decisions if implementing
    // this class for professional usage.


    // fields ////////////

    private int seconds;
    private int minutes;
    private int hours;


    // constructors

    // creates a "default" Duration of 0 hrs, mins, and secs
    public Duration() {

        hours = 0;
        minutes = 0;
        seconds = 0;
    }


    // creates a duration of specified length
    public Duration(int hr, int min, int sec) {

        // we want to make sure that hrs is 0 or more
        // and that min and sec both are between 0 and 59.
        // the setters enforce these rules, so we call the
        // setters rather than setting the variables directly.

        setHours(hr);
        setMinutes(min);
        setSeconds(sec);
    }


    // primary setters ///////////


    // sets the hours to the input amount
    // unless the input is negative, in which case
    // sets the hours to 0
    public void setHours(int amt) {
        if (amt < 0) {
            hours = 0;
        }
        else {
            hours = amt;
        }
    }


    // sets the minutes to the input amount
    // unless the input is negative, in which case
    // sets the minutes to 0.
    // if the input amount is 60 or more, then
    // also affects the stored hours amount.
    public void setMinutes(int amt) {
        if (amt < 0) {
            minutes = 0;
        }
        else {
            minutes = amt % 60;
            setHours(hours + (amt / 60));
        }
    }


    // sets the seconds to the input amount
    // unless the input is negative, in which case
    // sets the seconds to 0.
    // if the input amount is 60 or more, then
    // also affects the stored minutes amount
    // (and possibly, in turn, stored hours)
    public void setSeconds(int amt) {
        if (amt < 0) {
            seconds = 0;
        }
        else {
            seconds = amt % 60;
            setMinutes(minutes + (amt / 60));
        }
    }


    // secondary setter (or "convenience setter")

    // sets hours, minutes, and seconds, in that order,
    // based on the rules of the primary setters
    public void setDuration(int hr, int min, int sec) {
        setHours(hr);
        setMinutes(min);
        setSeconds(sec);
    }


    // primary getters ///////////////


    // returns the number of hours
    public int getHours() {
        return hours;
    }


    // returns the number of minutes
    public int getMinutes() {
        return minutes;
    }


    // returns the number of seconds
    public int getSeconds() {
        return seconds;
    }


    // secondary getters /////////

    // get the grand total number of seconds of the duration
    public int getTotalSeconds() {
        int total = seconds;
        total += (minutes * 60);
        total += (hours * 3600);
        return total;
    }

    // get the amount of time between the 2 durations
    // without respect to which one is longer or shorter
    public Duration getTimeBetween(Duration that) {

        // here, "this" is used to explicitly indicate
        // which object's values we are working with.
        // but use of "this" here is optional and could
        // be written simply getTotalSeconds()
        int thisSec = this.getTotalSeconds();


        int thatSec = that.getTotalSeconds();
        int diff = Math.abs(thisSec - thatSec);
        Duration between = new Duration(0, 0, diff);
        return between;
    }


    // returns the duration as a String in a time format
    // using only minutes and seconds; converts any hours
    // above 0 to minutes in the result.  For example, a
    // duration of 1 hour, 30 minutes, 5 seconds is returned
    // as "90:05"
    public String getTimeMinutesSeconds() {
        int totMin = (hours * 60) + minutes;
        String time = String.format("%d:%02d", totMin, seconds);
        return time;
    }


    // returns the duration as a String in a time format
    // using hours, minutes and seconds.  For example, a
    // duration of 1 hour, 8 minutes, 6 seconds is returned
    // as "1:08:06"
    // for times under 1 hour, returns the same String that
    // getTimeMinutesSeconds() returns
    public String getTimeHoursMinutesSeconds() {
        if (hours > 0) {
            String time = String.format("%d:%02d:%02d", hours, minutes, seconds);
            return time;
        }
        else {
            return getTimeMinutesSeconds();
        }
    }


    // Java's built-in method for debugging... implicitly called
    // anytime you print an object or include an object in a String
    public String toString() {
        String fmt = "Duration[hr=%d,min=%d,sec=%d]";
        String str = String.format(fmt, hours, minutes, seconds);
        return str;
    }






    // below here...
    // ... other methods needed for collections to work properly
    // if we discuss these at all, it will be later in the course


    // needed for sorting lists of Duration objects
    // or sorting other objects with Durations inside
    public int compareTo(Duration d) {
        int comp = Integer.compare(this.hours, d.hours);
        if (comp == 0) {
            comp = Integer.compare(this.minutes, d.minutes);
            if (comp == 0) {
                comp = Integer.compare(this.seconds, d.seconds);
            }
        }
        return comp;
    }


    // needed for HashSet<Duration> and HashMap<Duration> to work properly
    public int hashCode() {
        String time = getTimeHoursMinutesSeconds();
        int hash = time.hashCode();
        return hash;
    }


    // for both of the equals methods:
    //   needed for collections of Duration objects to work properly, supporting
    //   methods like contains, add (for sets), put (for maps), etc.

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Duration) {
            return equals((Duration)(obj));
        }
        else {
            return false;
        }
    }

    public boolean equals(Duration d) {
        return (compareTo(d) == 0);
    }

}
