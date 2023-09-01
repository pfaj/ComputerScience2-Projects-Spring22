
public class Inspector {

    public static void main(String[] args) {

        // We will use the debugger to run through
        // lines of code small bits at a time and
        // watch how execution jumps from one code
        // file to the next.  Along the way, we learn
        // about how objects actually work and how
        // classes are written to allow objects to be
        // created, mutated, and accessed.


        // Trace the creation of an object
        Duration dur = new Duration();


        // Trace the getting of values
        System.out.println("\nNew object, default constructor");
        int field = dur.getHours();
        System.out.println("hours: " + field);

        field = dur.getMinutes();
        System.out.println("minutes: " + field);

        field = dur.getSeconds();
        System.out.println("seconds: " + field);


        // Observe an implicit call to the toString method
        System.out.println("\nPrint dur object");
        System.out.println("dur: " + dur);


        // Trace the setting of values
        System.out.println("\nset hours to 2");
        dur.setHours(2);
        System.out.println("dur: " + dur);

        System.out.println("\nset hours to -1");
        dur.setHours(-1);
        System.out.println("dur: " + dur);

        System.out.println("\nset minutes to 8");
        dur.setMinutes(8);
        System.out.println("dur: " + dur);

        System.out.println("\nset minutes to 5000");
        dur.setSeconds(5000);
        System.out.println("dur: " + dur);


        // Trace creation of object with custom constructor
        System.out.println("\nnew object, custom constructor");
        Duration cs2 = new Duration(1, 10, 0);
        System.out.println("cs2: " + cs2);


        // Trace the calling of a secondary getter
        System.out.println("\nnew object, difference between old objects");
        Duration dif = cs2.getTimeBetween(dur);
        System.out.println("dif: " + dif);

        System.out.println("\nnew object, difference in other direction");
        dif = dur.getTimeBetween(cs2);
        System.out.println("dif: " + dif);


        // Trace creation of a different object, which happens
        // to have another object living inside of itself
        System.out.println("\nnew Song object, custom constructor");
        Song ok = new Song("Stayin' Alive", "Bee Gees", 4, 45);


        // Observe again how toString is called implicitly,
        // and twice this time (Song's and Duration's methods)
        System.out.println("ok: " + ok);


        // Trace default constructor
        System.out.println("\nnew Song object, default constructor");
        Song def = new Song();
        System.out.println("def: " + def);



        // Observe what happens when we call getLength()
        // and then what happens if we change the returned object
        System.out.println("\nget length of ok song (dur object)");
        dur = ok.getLength();
        System.out.println("dur: " + dur);

        System.out.println("\nchange dur object; did Song duration change?");
        dur.setDuration(11, 22, 33);
        System.out.println(" ok: " + ok);
        System.out.println("dur: " + dur);


        // If time remains, we can try other method calls
        // adding or altering existing methods in the other classes
        // creating our own new class, etc.
    }

}
