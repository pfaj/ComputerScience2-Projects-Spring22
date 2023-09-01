// Models basic Song data: title, artist, time length


// ignore this part, this is
// needed for sorting and will
// be explained in 2 weeks
public class Song           implements Comparable<Song> {

    // fields //////

    private String title;
    private String artist;
    private Duration length;


    // constructors /////

    public Song() {

        // to have a single, consistent constructor
        // "this" is used to redirect initialization
        // to the other constructor

        this("", "", 0, 0);

    }


    public Song(String title, String artist, int min, int sec) {

        // the field names match the input parameter names, so
        // the "this." syntax is used in order to refer to
        // the field variables

        this.title = title;
        this.artist = artist;


        // the field name is different from the input parameter
        // names, so the "this." syntax can be used or omitted.
        // here, it is omitted

        length = new Duration(0, min, sec);

    }

    // setters /////


    public void setTitle(String title) {
        this.title = title;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }


    public void setLength(int min, int sec) {
        length = new Duration(0, min, sec);
    }


    // getters /////


    // returns the title
    public String getTitle() {
        return title;
    }


    // returns the artist
    public String getArtist() {
        return artist;
    }


    // We don't want to return the private object here because
    // now the "outside world" can mess with our "inside world"
    // where we might want to restrict the length in some way.
    //
    // So, we make a brand new object with the same data as the
    // private object and return the new object.  Any changes
    // made to the new object do not affect the private object.
    public Duration getLength() {

        int hrs = length.getHours();
        int mins = length.getMinutes();
        int secs = length.getSeconds();

        Duration copy = new Duration(hrs, mins, secs);
        return copy;
    }


    public String toString() {
        String fmt = "Song[title=%s,artist=%s,length=%s]";
        String str = String.format(fmt, title, artist, length);
        return str;
    }





    // below here...
    // ... other methods needed for collections to work properly
    // if we discuss these at all, it will be later in the course


    // needed to be able to sort lists/arrays of Song objects
    public int compareTo(Song s) {
        int comp = this.artist.compareTo(s.artist);
        if (comp == 0) {
            comp = this.title.compareTo(s.title);
            if (comp == 0) {
                comp = this.length.compareTo(s.length);
            }
        }
        return comp;
    }


    // needed for HashSet<Song> and HashMap<Song> to work properly
    public int hashCode() {
        String time = length.getTimeMinutesSeconds();
        String all = title + artist + time;
        int hash = all.hashCode();
        return hash;
    }


    // both equals needed for collection methods to work properly
    // (like ArrayList's contains, indexOf, etc.)

    public boolean equals(Song s) {
        int comp = compareTo(s);
        return (comp == 0);
    }


    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Song) {
            return equals((Song)(obj));
        }
        else {
            return false;
        }
    }

}
