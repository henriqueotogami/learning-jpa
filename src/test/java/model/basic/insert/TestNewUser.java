package model.basic.insert;

import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

public class TestNewUser {

    public static void main(String[] args) {
        System.out.println("TestNewUser: BEGIN");
        try {
            PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
            createEntityConnection.createConnection();

            User newUser = new User("Henrique Otogami", "h-otogami@icloud.com");
            newUser.setId(1L);

            createEntityConnection.getConnectionDatabase().getTransaction().begin();
            createEntityConnection.getConnectionDatabase().persist(newUser);
            createEntityConnection.getConnectionDatabase().getTransaction().commit();

            System.out.println("New User ID: " + newUser.getId());
            createEntityConnection.closeConnection();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("TestNewUser: END");
        }

    }
}
