package model.basic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestNewUser {

    public static void main(String[] args) {

        try {
            final String mysqlDatabase = "course_java";
            EntityManagerFactory persistenceManager = Persistence.createEntityManagerFactory(mysqlDatabase);
            EntityManager factoryConnectionDatabase = persistenceManager.createEntityManager();

            User newUser = new User("Henrique Otogami", "h-otogami@icloud.com");
//            newUser.setId(1L);

            factoryConnectionDatabase.getTransaction().begin();
            factoryConnectionDatabase.persist(newUser);
            factoryConnectionDatabase.getTransaction().commit();

            System.out.println("New User ID: " + newUser.getId());

            factoryConnectionDatabase.close();
            persistenceManager.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
