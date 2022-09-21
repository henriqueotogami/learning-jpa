package model.basic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
