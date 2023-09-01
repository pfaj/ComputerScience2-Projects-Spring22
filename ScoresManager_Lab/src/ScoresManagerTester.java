import java.util.ArrayList;

public class ScoresManagerTester {

    public static void main(String[] args) {

        // constructor test
        ScoresManager mgr = new ScoresManager();
        print("New ScoresManager created", mgr);

        // add test - scores in range
        double[] sampleGoodScores = {8.8, 6.6, 7.7, 5.5, 3.3, 0.0, 9.9};
        for (double score : sampleGoodScores) {
            testAdd("Should have added ", score, mgr);
        }

        // add test - scores out of range
        double[] sampleBadScores = {-0.1, -1.0, -10.0, 10.01, 10.1, 100.1};
        for (double score : sampleBadScores) {
            testAdd("Should not have added ", score, mgr);
        }

        // stats test - odd length list of scores
        ArrayList<Double> stats = mgr.getStats();
        System.out.println("stats is " + stats);

        // add another value
        testAdd("Should have added ", 1.1, mgr);

        // stats test - even length list of scores
        stats = mgr.getStats();
        System.out.println("stats is " + stats);

        // changeRange test
        mgr.changeRange(1.0, 5.0);
        print("Changed range to (1.0, 5.0)", mgr);
    }

    public static void print(String message, ScoresManager mgr) {
        System.out.println(message);
        System.out.println("getMinScore test: " + mgr.getMinScore());
        System.out.println("getMaxScore test: " + mgr.getMaxScore());
        System.out.println("  getScores test: " + mgr.getScores());
        System.out.println();
    }

    public static void testAdd(String message, double score, ScoresManager mgr) {
        mgr.add(score);
        System.out.println(message + score);
        System.out.println("  getScores test: " + mgr.getScores());
    }

}
