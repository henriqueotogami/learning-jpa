package model.basic.delete;

import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

public class TestDeleteUser {

    public static void main(String[] args) {

        try {
            System.out.println("TestDeleteUser - main(): BEGIN");
            PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
            createEntityConnection.createConnection();

            final User deleteUser = createEntityConnection.getConnectionDatabase().find(User.class, 3L);
            System.out.println("Old user: " + deleteUser.getName() + " | ID: " + deleteUser.getId());
            System.out.println("Old e-mail: " + deleteUser.getEmail());

            if (deleteUser != null) {
                createEntityConnection.getConnectionDatabase().getTransaction().begin();
                createEntityConnection.getConnectionDatabase().remove(deleteUser);
                createEntityConnection.getConnectionDatabase().getTransaction().commit();
                System.out.println("TestDeleteUser - main(): Selected user has been deleted from the database.");
            }

            createEntityConnection.closeConnection();
        } catch (final Exception exception) {
            System.out.println("TestDeleteUser - main(): Attempt to delete the selected user from the database fails.");
        }
        System.out.println("TestDeleteUser - main(): END");
    }
}
