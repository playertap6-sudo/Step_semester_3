package hackathon.practice_problems;

public class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = (cgpa * 10) + (codingScore / 2.0);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}