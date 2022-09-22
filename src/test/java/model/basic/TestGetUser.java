package model.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestGetUser {

    public static void main(String[] args) {

        EntityManagerFactory createConnectionDatabase = Persistence.createEntityManagerFactory("course_java");
        EntityManager databaseConnected = createConnectionDatabase.createEntityManager();

        User user = databaseConnected.find(User.class, 1);
        System.out.println("User found: " + user.getName());

        databaseConnected.close();
        createConnectionDatabase.close();

    }
}
