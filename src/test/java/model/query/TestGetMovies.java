package model.query;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.manytomany.Movie;

import java.util.List;

public class TestGetMovies extends TestCase {

    private static boolean isSuccessGetMovies = false;

    public static void main(String[] args) { startTest(); }

    private static void startTest() {
        System.out.println("TestGetMovies: BEGIN");
        try {
            final DataAccessObject<Movie> dataAccessMovie = new DataAccessObject<Movie>(Movie.class);
            try {
                final List<Movie> moviesList =
                        dataAccessMovie.queryAllEntities("getMoviesRatingHigherThan", "rating", 8.5);
                for(Movie movie: moviesList){ System.out.println("TestGetMovies - Movie name: " + movie.getName()); }
                isSuccessGetMovies = (moviesList.size() > 0);
            } catch (final Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessGetMovies);
                dataAccessMovie.closeConnectionDatabase();
                System.out.println("TestGetMovies: END");
            }
        } catch (final Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }
}
