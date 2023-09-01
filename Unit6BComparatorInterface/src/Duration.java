// Models a duration of time greater than
// or equal to 0 hours, 0 minutes, 0 seconds

public class Duration implements Comparable<Duration> {

    // fields ////////////

    private int seconds;
    private int minutes;
    private int hours;


    // compareTo usually not at the top, but placed here
    // today to make it easy to see the relationship between
    // the compareTo method and the Duration class fields

    @Override
    public int compareTo(Duration d) {

        // compare the hours first
        int comp = Integer.compare(this.hours, d.hours);

        // compare the minutes only when the hours are the same
        if (comp == 0) {
            comp = Integer.compare(this.minutes, d.minutes);

            // compare the seconds only when the minutes are the same
            if (comp == 0) {
                comp = Integer.compare(this.seconds, d.seconds);
            }
        }

        return comp;
    }


    // constructors

    public Duration() {
        this(0, 0, 0);
    }


    public Duration(int hr, int min, int sec) {
        setHours(hr);
        setMinutes(min);
        setSeconds(sec);
    }


    // setters ///////////


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


    // getters ///////////////


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


    public boolean equals(Duration d) {
        return (compareTo(d) == 0);
    }


    public String toString() {
        String fmt = "Duration[hr=%d,min=%d,sec=%d]";
        String str = String.format(fmt, hours, minutes, seconds);
        return str;
    }


    // other methods needed for collections to work properly /////


    // needed for HashSet<Duration> and HashMap<Duration> to work properly
    public int hashCode() {
        final int prime = 31;
        int hash = 7;
        hash = (hash * prime) + hours;
        hash = (hash * prime) + minutes;
        hash = (hash * prime) + seconds;
        return hash;
    }


    // needed for collections of Duration objects to work properly
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Duration) {
            return equals((Duration)(obj));
        }
        else {
            return false;
        }
    }

}
