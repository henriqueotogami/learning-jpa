package model.onetoone;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.database.jpa.PersistenceEntityManager;
import model.onetoone.Client;
import model.onetoone.Seat;

public class TestNewClientNewSeat extends TestCase {

    private static boolean isSuccessAddNewClientAndSeat = false;

    public static void main(String[] args) {

        startTest();
    }

    private static void startTest() {
        System.out.println("TestNewClientNewSeat: BEGIN");
        try {
             Seat seat = new Seat("16C");
             Client client = new Client("Ana", seat);

             DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();

             dataAccessObject.openTransactionalDAO()
                     .includeTransactionalDAO(seat)
                     .includeTransactionalDAO(client)
                     .closeTransactionalDAO()
                     .closeConnectionDatabase();

                isSuccessAddNewClientAndSeat = true;

        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessAddNewClientAndSeat);
            System.out.println("TestNewClientNewSeat: END");
        }
    }
}
