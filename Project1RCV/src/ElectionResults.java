import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ElectionResults {

    // the main method works as follows:
    // - provided code (leave this code as is):
    //   - prompts user for file name containing ballot data
    //   - reads data into array (one array item per line in file)
    //   - runs any testing code that you have written
    // - code you need to write:
    //   - execute the Ranked Choice Voting process as outlined
    //     in the project description document by calling the other
    //     methods that you will implement in this project
    public static void main(String[] args) {
        // Establish console Scanner for console input
        Scanner console = new Scanner(System.in);

        // Determine the file name containing the ballot data
        System.out.print("Ballots file: ");
        String fileName = console.nextLine();

        // Read the file contents into an array.  Each array
        // entry corresponds to a line in the file.
        String[] fileContents = getFileContents(fileName);

        // Your code below here: execute the RCV process,
        // ensuring to make use of the remaining methods
        ArrayList<Ballot> list = convert(fileContents);
        Boolean winnerFound = analyze(tallies(list)).isWinner();
        while(!winnerFound){
            remove(analyze(tallies(list)).getName(), list);
            tallies(list);
            list = list;
            winnerFound = analyze(tallies(list)).isWinner();
            printCounts(tallies(list));
            printPercentages(tallies(list));
        }
        System.out.println(analyze(tallies((list))).getName() + " wins!");
        System.out.println();


//        printCounts(tallies);
//        printPercentages(tallies);
//        System.out.println("Method 1: " + convert(fileContents));
//        System.out.println("Method 2: " + tallies(convert));
//        System.out.println("Method 3: " + countTotalVotes(tallies));
//        System.out.println("Method 4: " + analyze(tallies));
//        System.out.println("Method 5: ");
    }

    // Create your methods below here


    public static ArrayList<Ballot> convert(String[] fileLine){
        ArrayList<Ballot> ballotList = new ArrayList<Ballot>();
        for (String votes : fileLine) {
            String[] voteList = votes.split(",");
            Ballot ballot = new Ballot();
            for(String vote : voteList) {
                ballot.addCandidate(vote);
            }
            ballotList.add(ballot);
        }
        return ballotList; // delete and replace with your code
    }

    public static  HashMap<String, Integer> tallies(ArrayList<Ballot> candidateVote){
        HashMap<String, Integer> tallies = new HashMap<String, Integer>();
        for(int i = 0; i < candidateVote.size(); i++){

            String currVote = candidateVote.get(i).getCurrentChoice();
            int num = 0;

            if(tallies.containsKey(currVote)){
                tallies.put(currVote, tallies.get(currVote) + 1);
            }
            else{
                tallies.put(currVote, 1);
            }
        }
        // for each
        return tallies;
    }

    public static int countTotalVotes(HashMap<String, Integer> candidateVote){
        int sum = 0;
        for(String key : candidateVote.keySet()){
            sum += candidateVote.get(key);
        }
        return sum;
    }

    public static Result analyze(HashMap<String, Integer> candidateVote) {
        Result candidate = new Result();
        int total = countTotalVotes(candidateVote);
        int minValue = 1000000;
        for (String key : candidateVote.keySet()) {
            int votes = candidateVote.get(key);
            int half = (total /  2) ;
            if (votes > half) {
                candidate.setName(key);
                candidate.setWin(true);
                if(candidate.isWinner()){}
                return candidate;
            }
            if (votes < minValue && candidate.isLoser()){
                minValue = votes;
                candidate.setName(key);
                candidate.setWin(false);
            }
        }
        return candidate;
    }

    public static void printCounts(HashMap<String, Integer> voteCounts){
        System.out.println("Vote Tallies");
        for (String key : voteCounts.keySet()) {
            System.out.println(key + ":" + voteCounts.get(key));
            }
        System.out.println();
    }

    public static void remove(String name, ArrayList<Ballot> ballotList){
        for(int i=0; i < ballotList.size(); i++) {
            Ballot candidate = ballotList.get(i);
            String person =  candidate.getCurrentChoice();
            if (person.contains(name)) {
                candidate.removeCandidate(name);
                System.out.println("Remove: " + name);
                System.out.println();

            }
            if (candidate.isExhausted()) {
                ballotList.remove(candidate);
            }
        }
    }

    public static void printPercentages(HashMap<String, Integer> candidateVote){
        System.out.println("Vote Percentages");
        int total = countTotalVotes(candidateVote);
        for (String key : candidateVote.keySet()) {
            int votes = candidateVote.get(key);
            double percent = ((double)votes /  total) * 100 ;
            System.out.print(key + ":");
            System.out.printf("%.2f", percent);
            System.out.println("%");
        }
        System.out.println();
    }

    // DO NOT edit the methods below. These are provided to help you get started.
    public static String[] getFileContents(String fileName) {

        // first pass: determine number of lines in the file
        Scanner file = getFileScanner(fileName);
        int numLines = 0;
        while (file.hasNextLine()) {
            file.nextLine();
            numLines++;
        }

        // create array to hold the number of lines counted
        String[] contents = new String[numLines];

        // second pass: read each line into array
        file = getFileScanner(fileName);
        for (int i = 0; i < numLines; i++) {
            contents[i] = file.nextLine();
        }

        return contents;
    }


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
