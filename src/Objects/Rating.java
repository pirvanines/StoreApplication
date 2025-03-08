package Objects;

public class Rating {
    private double grade;
    private int numOfRatings;
    private int sumOfRatings;

    public Rating(double grade, int numOfRatings, int sumOfRatings)
    {
        this.grade = grade;
        this.numOfRatings = numOfRatings;
        this.sumOfRatings = sumOfRatings;
    }

    public void addRating(int stars)
    {
        sumOfRatings = sumOfRatings + stars;
        numOfRatings = numOfRatings + 1;

        grade = (double) sumOfRatings / (double) numOfRatings;
    }

    public double getGrade()
    {
        return grade;
    }

    public int getNumOfRatings()
    {
        return numOfRatings;
    }
}
