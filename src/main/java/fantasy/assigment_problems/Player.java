package fantasy.assigment_problems;

public class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;
    double fantasyPoints;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
        this.fantasyPoints = battingAverage * matchesPlayed;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints, this.fantasyPoints);
    }
}