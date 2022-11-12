package model.basic.insert;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
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
            final Seat seat = new Seat("16C");
            final Client client = new Client("Ana", seat);

            final DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();

            dataAccessObject.openTransactionalDAO()
                    .includeTransactionalDAO(seat)
                    .includeTransactionalDAO(client)
                    .closeTransactionalDAO()
                    .closeConnectionDatabase();

        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("TestNewClientNewSeat: END");
        }
    }
}
