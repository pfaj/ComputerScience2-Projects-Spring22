public class team {
    private String name;
    private int wins;
    private int losses;


    public String toString() {
        String format = "Team[name=%s,wins=%d,losses=%d]";
        String str = String.format(format,name, wins,losses);
        return str;
    }

    public Team() {
        name = "";
        wins = 0;
        losses = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void addWin(){
        wins++;
    }

    public void addLoss(){
        losses++;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getGames(){
        int games;
        games = wins + losses;
        return games;
    }

    public double getWinPct(){
        double games =  getGames();
        double pct;
        if (games == 0){
            return 0.0;
        }
        else{
            pct = wins / games;
        }
        return pct;

    }

}
