package model.query;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.manytomany.MovieRating;

public class TestGetAverageMovieRating extends TestCase {

    private static boolean isSuccessGetAverageMovieRating = false;

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        System.out.println("TestGetAverageMovieRating: BEGIN");
        try {
            DataAccessObject<MovieRating> dataAccessMovieRating = new DataAccessObject<MovieRating>(MovieRating.class);
            try {
                MovieRating movieRating = dataAccessMovieRating.queryFirstEntity("getMovieRating");
                System.out.println("TestGetAverageMovieRating: movieRating.getAverageMovieRatings() " + movieRating.getAverageMovieRatings());
                isSuccessGetAverageMovieRating = (movieRating.getAverageMovieRatings() > 0D);
            } catch (final Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessGetAverageMovieRating);
                dataAccessMovieRating.closeConnectionDatabase();
                System.out.println("TestGetAverageMovieRating: END");
            }
        } catch (final Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }

}
