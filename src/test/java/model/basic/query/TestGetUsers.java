package model.basic.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import junit.framework.TestCase;
import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

import java.util.List;

public class TestGetUsers extends TestCase {

    private static boolean isSuccessQueryOne = false;
    private static boolean isSuccessQueryTwo = false;

    private static final String DOTTED_LINE = "------------------------------------------------------------";
    private static final char NEW_LINE = '\n';

    public static void main(String[] args) {

        System.out.println("TestGetUsers: BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        createEntityConnection.createConnection();

        executeQueryOne(createEntityConnection.getConnectionDatabase());
        System.out.println(DOTTED_LINE + NEW_LINE);
        System.out.println(DOTTED_LINE);
        executeQueryTwo(createEntityConnection.getConnectionDatabase());

        assertEquals(isSuccessQueryOne, isSuccessQueryTwo);
        System.out.println(NEW_LINE + DOTTED_LINE);
        System.out.println("TestGetUsers: User query performed SUCCESSFULLY.");
        System.out.println(DOTTED_LINE + NEW_LINE);

        createEntityConnection.closeConnection();
        System.out.println("TestGetUsers: END");
    }

    /**
     *
     * @param databaseConnected
     */
    private static void executeQueryOne(final EntityManager databaseConnected) {
        System.out.println("TestGetUsers - executeQueryOne(): BEGIN");
        final String javaPersistenceQueryLanguage = "SELECT user FROM User user";
        final TypedQuery<User> answerQuery = databaseConnected.createQuery(javaPersistenceQueryLanguage, User.class);
        answerQuery.setMaxResults(5);

        final List<User> answerQueryUsers = answerQuery.getResultList();
        for(User user: answerQueryUsers) {
            System.out.println("User: " + user.getName());
            System.out.println("ID: " + user.getId());
        }
        isSuccessQueryOne = (answerQueryUsers.isEmpty() != false);
        System.out.println("TestGetUsers - executeQueryOne(): END");
    }

    /**
     *
     * @param databaseConnected
     */
    private static void executeQueryTwo(final EntityManager databaseConnected) {
        final String thisClassName = TestGetUsers.class.getName();
        final String thisMethodName = TestGetUsers.class.getDeclaredMethods()[2].getName();
        System.out.println(thisClassName + " - " + thisMethodName + "(): BEGIN");

        final String javaPersistenceQueryLanguage = "SELECT user FROM User user";
        final List<User> answerQueryUsers = databaseConnected
                                        .createQuery(javaPersistenceQueryLanguage, User.class)
                                        .setMaxResults(5)
                                        .getResultList();

        for(User user: answerQueryUsers) {
            System.out.println("User: " + user.getName());
            System.out.println("ID: " + user.getId());
        }
        isSuccessQueryTwo = (answerQueryUsers.isEmpty() != false);
        System.out.println(thisClassName + " - " + thisMethodName + "(): END");
    }
}
