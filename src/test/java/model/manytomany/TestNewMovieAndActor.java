package model.manytomany;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.manytomany.Actor;
import model.manytomany.Movie;

public class TestNewMovieAndActor extends TestCase {

    private static boolean isSuccessNewMovieAndActor = false;

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        System.out.println("TestNewMovieAndActor: BEGIN");
        try {
            DataAccessObject<Movie> dataAccessMovie = new DataAccessObject<Movie>();
            try {
                final Movie starWarsMovie = new Movie("Star Wars - Ep VII", 9.7);
                final Movie theLastDuelMovie = new Movie("The Last Duel", 8.4);
                final Movie opheliaMovie = new Movie("Ophelia", 7.8);
                final Actor adamDriver = new Actor("Adam Driver");
                final Actor daisyRiddley = new Actor("Daisy Riddley");

                starWarsMovie.addActorToMovie(adamDriver);
                starWarsMovie.addActorToMovie(daisyRiddley);
                theLastDuelMovie.addActorToMovie(adamDriver);
                opheliaMovie.addActorToMovie(daisyRiddley);


                dataAccessMovie.includeAtomicTransactionalDAO(starWarsMovie);

                isSuccessNewMovieAndActor = true;
            } catch (final Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessNewMovieAndActor);
                dataAccessMovie.closeConnectionDatabase();
                System.out.println("TestNewMovieAndActor: END");
            }
        } catch (final Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }
}
