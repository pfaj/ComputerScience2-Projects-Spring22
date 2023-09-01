import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {

    public static void main(String[] args) {

        // set up the list
        LinkedList<Double> scores = new LinkedList<>();
        scores.add(8.6);
        scores.add(7.5);
        scores.add(3.0);
        scores.add(9.2);
        scores.add(7.8);
        scores.add(3.1);

        // get an iterator on the list
        ListIterator<Double> it = scores.listIterator();

        // get the next (first) item in the list
        // AND move the iterator to the next position
        double aScore = it.next();
        System.out.println("aScore after 1st call to next(): " + aScore);

        // get the next (second) item in the list
        // AND move the iterator to the next position
        aScore = it.next();
        System.out.println("aScore after 2nd call to next(): " + aScore);

        // move the iterator to the next position THEN
        // get the next (fourth) item in the list after that
        // AND move the iterator to the next position
        it.next();
        aScore = it.next();
        System.out.println("aScore after 4th call to next(): " + aScore);

        // get the previous (still fourth) item in the last
        // AND move the iterator to the previous position
        aScore = it.previous();
        System.out.println("aScore after 1st call to previous(): " + aScore);

        // move the iterator to the next position THEN
        // get the next (fifth) item in the list after that
        // AND move the iterator to the next position
        it.next();
        aScore = it.next();
        System.out.println("aScore after 2 more calls to next(): " + aScore);

        // remove the most recently passed (fifth) item in the list
        System.out.println("\nlist before calling it.remove(): " + scores);
        it.remove();
        System.out.println("list  after calling it.remove(): " + scores);

        // re-establish the position of the iterator
        aScore = it.previous();
        System.out.println("aScore after call to previous(): " + aScore);

        // remove the most recently passed item in the list
        it.remove();
        System.out.println("list  after calling it.remove(): " + scores);

        // re-establish the position of the iterator
        aScore = it.previous();
        System.out.println("aScore after call to previous(): " + aScore);

        // add an item at the current iterator position
        it.add(2.4);
        System.out.println("list  after calling it.add():    " + scores);

        // re-establish the position of the iterator
        aScore = it.next();
        System.out.println("aScore after call to next():     " + aScore);

        // add an item at the current iterator position
        it.add(0.9);
        System.out.println("list  after calling it.add():    " + scores);

        // reset the list iterator
        it = scores.listIterator();

        // print the list forward
        System.out.println("\nThe list, element by element (forward)");
        while (it.hasNext()) {
            aScore = it.next();
            System.out.println("- " + aScore);
        }

        // the iterator is at the end of the list
        // we can iterate backward through the list too
        System.out.println("\nThe list, element by element (backward)");
        while (it.hasPrevious()) {
            aScore = it.previous();
            System.out.println("- " + aScore);
        }

    }

}
