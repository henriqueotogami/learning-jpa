package model.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TestGetUsers {

    public static void main(String[] args) {

        final String databaseName = "course_java";
        EntityManagerFactory createConnectionDatabase = Persistence.createEntityManagerFactory(databaseName);
        EntityManager databaseConnected = createConnectionDatabase.createEntityManager();

        executeQueryOne(databaseConnected);
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        executeQueryTwo(databaseConnected);

        databaseConnected.close();
        createConnectionDatabase.close();
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
