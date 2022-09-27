package model.basic.query;

import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

public class TestGetUser {

    public static void main(String[] args) {
        System.out.println("TestGetUser: BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        createEntityConnection.createConnection();

        User user = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
        System.out.println("User found: " + user.getName());

        createEntityConnection.closeConnection();
        System.out.println("TestGetUser: END");
    }
}
