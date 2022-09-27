package model.basic.update;

import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

public class TestChangeUser {

    public static void main(String[] args) {
        System.out.println("TestChangeUser: BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        createEntityConnection.createConnection();

        createEntityConnection.getConnectionDatabase().getTransaction().begin();
        final User updateUser = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
        System.out.println("Old user: " + updateUser.getName() + " | ID: " + updateUser.getId());
        System.out.println("Old e-mail: " + updateUser.getEmail());

        updateUser.setName("Henrique Otogxm1");
        updateUser.setEmail("hen-otogxm1@icloud.com");

        createEntityConnection.getConnectionDatabase().merge(updateUser);
        createEntityConnection.getConnectionDatabase().getTransaction().commit();
        createEntityConnection.closeConnection();
        System.out.println("TestChangeUser: BEGIN");
    }
}
