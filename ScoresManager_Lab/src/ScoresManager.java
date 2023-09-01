import java.util.ArrayList;

public class ScoresManager {

    // fields //////////////////////////////////////////////////

    private ArrayList<Double> scores;
    private double minScore;
    private double maxScore;


    // constructor /////////////////////////////////////////////

    // sets the fields:
    // initial minimum score of 0.0
    // initial maximum score of 10.0
    // initial scores list is empty (but not null)
    public ScoresManager() {
        minScore = 0.0;
        maxScore = 10.0;
        scores = new ArrayList<Double>();

    }


    // getters and setters to implement ////////////////////////

    // if the score is in range, add it to the list, ensuring to
    // keep the list in ascending sorted order (low to high)
    public void add(double score) {
        if(score >= minScore && score <= maxScore) {
            scores.add(score);
        }
        scores.sort(null);
    }


    // return a new list containing the following elements, in this order
    // - the minimum score in the list of scores
    // - if the list size is odd, the median
    // - if the list size is even, the 2 middle elements
    // - the maximum score in the list of scores
    public ArrayList<Double> getStats() {
        ArrayList<Double> stats = new ArrayList<>();
        double median;
        double medianTwo = 0;
        int size = getScores().size();
        if(size == 0){
            return stats;
        }
        else if (size % 2 == 0) {
            int midIndex = size / 2;
            median = getScores().get(midIndex - 1);
            medianTwo = getScores().get(midIndex);

        } else {
            int midIndex = size / 2;
            median = getScores().get(midIndex);
            medianTwo = 0.0;
        }
        stats.add(getScores().get(0));
        if (size % 2 == 0) {
            stats.add(median);
            stats.add(medianTwo);
        } else {
            stats.add(median);
            //stats.add(medianTwo);
        }
        stats.add(getScores().get(getScores().size() - 1));
        return stats; // delete this line
    }


    // if the min is more than the max, do nothing
    // otherwise:
    // - change the minimum and maximum scores using the inputs
    // - remove any elements in scores that are now out of range
    public void changeRange(double min, double max) {
        ArrayList<Double> nums = new ArrayList<>();
        if (!(min > max)){
            minScore = min;
        }
        if (!(max < min)){
            maxScore = max;
        }
        for(int i = 0; i < getScores().size(); i++){
            double score = getScores().get(i);
            if(!(score >= minScore && score <= maxScore)) {
                nums.add(score);
            }
        }
        scores.removeAll(nums);
    }


    // methods below here are already implemented - do not change

    public double getMinScore() {
        return minScore;
    }


    public double getMaxScore() {
        return maxScore;
    }


    // we don't want to return the list itself, because the
    // outside world now has direct access to the list, so
    // we return a copy instead.
    public ArrayList<Double> getScores() {
        if (scores == null) {
            return null;
        }

        return copyScores();
    }


    private ArrayList<Double> copyScores() {
        ArrayList<Double> copy = new ArrayList<Double>();
        for (double score : scores) {
            copy.add(score);
        }
        return copy;
    }

}