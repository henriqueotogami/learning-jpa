package model.basic.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

import java.util.List;

public class TestGetUsers {

    public static void main(String[] args) {

        System.out.println("TestGetUsers: BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        createEntityConnection.createConnection();

        executeQueryOne(createEntityConnection.getConnectionDatabase());
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        executeQueryTwo(createEntityConnection.getConnectionDatabase());

        createEntityConnection.closeConnection();
        System.out.println("TestGetUsers: END");
    }

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
        System.out.println("TestGetUsers - executeQueryOne(): END");
    }

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
        System.out.println(thisClassName + " - " + thisMethodName + "(): END");
    }
}
