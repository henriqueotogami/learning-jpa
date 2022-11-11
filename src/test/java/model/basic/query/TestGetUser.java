package model.basic.query;

import junit.framework.TestCase;
import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

public class TestGetUser extends TestCase {

    private static boolean isSuccessGetUser = false;

    public static void main(String[] args) {
        startTest();
    }

    public static void startTest() {
        System.out.println("TestGetUser: BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        try {
            createEntityConnection.createConnection();
            User user = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            System.out.println("TestGetUser - User found: " + user.getName());
            isSuccessGetUser = (user.getName().isEmpty() == false);
        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessGetUser);
            createEntityConnection.closeConnection();
            System.out.println("TestGetUser: New user query performed successfully.");
            System.out.println("TestGetUser: END");
        }
    }
}
