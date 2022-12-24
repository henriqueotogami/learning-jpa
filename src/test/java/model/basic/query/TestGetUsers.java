package model.basic.query;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import junit.framework.TestCase;
import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

import java.util.List;

public class TestGetUsers extends TestCase {

    private static boolean isSuccessQueryOne = false;
    private static boolean isSuccessQueryTwo = false;

    private static final String DOTTED_LINE = "------------------------------------------------------------";
    private static final char NEW_LINE = '\n';

    private static int databaseStorageUsers;

    public static int getDatabaseStorageUsers() { return databaseStorageUsers; }

    public static void setDatabaseStorageUsers(int databaseStorageUsers) {
        TestGetUsers.databaseStorageUsers = databaseStorageUsers;
    }

    public static void main(String[] args) {

        startTest();
    }

    public static int startTest() {
        System.out.println("TestGetUsers: BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        try {
            createEntityConnection.createConnection();

            executeQueryOne(createEntityConnection.getConnectionDatabase());
            System.out.println(DOTTED_LINE + NEW_LINE);
            System.out.println(DOTTED_LINE);
            executeQueryTwo(createEntityConnection.getConnectionDatabase());

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            assertEquals(isSuccessQueryOne, isSuccessQueryTwo);
            createEntityConnection.closeConnection();
            System.out.println(NEW_LINE + DOTTED_LINE);
            System.out.println("TestGetUsers: User query performed SUCCESSFULLY.");
            System.out.println(DOTTED_LINE + NEW_LINE);
            System.out.println("TestGetUsers: END");
        }
        return getDatabaseStorageUsers();
    }

    /**
     * Executa a consulta da quantidade de usuários registrados no banco de dados, tratando o retorno utilizando a
     * interface de consultas de persistência.
     * @param databaseConnected Instância do banco de dados conectado.
     */
    private static void executeQueryOne(final EntityManager databaseConnected) {
        System.out.println("TestGetUsers - executeQueryOne(): BEGIN");
        try {
            final String javaPersistenceQueryLanguage = "SELECT user FROM User user";
            final TypedQuery<User> answerQuery = databaseConnected.createQuery(javaPersistenceQueryLanguage, User.class);
            answerQuery.setMaxResults(5);

            final List<User> answerQueryUsers = answerQuery.getResultList();
            for (User user : answerQueryUsers) {
                System.out.println("User: " + user.getName());
                System.out.println("ID: " + user.getId());
            }
            setDatabaseStorageUsers(answerQueryUsers.size());
            isSuccessQueryOne = (answerQueryUsers.size() > 0);
        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("TestGetUsers - executeQueryOne(): END");
        }
    }

    /**
     * Executa a consulta da quantidade de usuários registrados no banco de dados, tratando o retorno utilizando a
     * interface de lista de objetos da api do Java.
     * @param databaseConnected Instância do banco de dados conectado.
     */
    private static void executeQueryTwo(final EntityManager databaseConnected) {
        final String thisClassName = TestGetUsers.class.getName();
        final String thisMethodName = TestGetUsers.class.getDeclaredMethods()[2].getName();
        System.out.println(thisClassName + " - " + thisMethodName + "(): BEGIN");
        try {
            final String javaPersistenceQueryLanguage = "SELECT user FROM User user";
            final List<User> answerQueryUsers = databaseConnected
                    .createQuery(javaPersistenceQueryLanguage, User.class)
                    .setMaxResults(5)
                    .getResultList();

            for (User user : answerQueryUsers) {
                System.out.println("User: " + user.getName());
                System.out.println("ID: " + user.getId());
            }
            setDatabaseStorageUsers(answerQueryUsers.size());
            isSuccessQueryTwo = (answerQueryUsers.size() > 0);
        } catch ( final Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println(thisClassName + " - " + thisMethodName + "(): END");
        }
    }
}
