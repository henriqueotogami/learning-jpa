package model.manytomany;

public class MovieRating {

    private double averageMovieRatings;

    public MovieRating(final double averageMovieRatings) {
        super();
        this.averageMovieRatings = averageMovieRatings;
    }

    public double getAverageMovieRatings() { return averageMovieRatings; }

    public void setAverageMovieRatings(final double averageMovieRatings) { this.averageMovieRatings = averageMovieRatings; }

}
