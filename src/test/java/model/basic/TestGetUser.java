package model.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestGetUser {

    public static void main(String[] args) {

        final String databaseName = "course_java";
        EntityManagerFactory createConnectionDatabase = Persistence.createEntityManagerFactory(databaseName);
        EntityManager databaseConnected = createConnectionDatabase.createEntityManager();

        User user = databaseConnected.find(User.class, 1L);
        System.out.println("User found: " + user.getName());

        databaseConnected.close();
        createConnectionDatabase.close();

    }
}
