package model.basic.delete;

import junit.framework.TestCase;
import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

public class TestDeleteUser extends TestCase {

    private static boolean isSuccessDeleteUser = false;

    public static void main(String[] args) {
        startTest();

    }

    private static void startTest() {
        System.out.println("TestDeleteUser - main(): BEGIN");
        final PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        try {

            createEntityConnection.createConnection();

            final User targetUserToDelete = createEntityConnection.getConnectionDatabase().find(User.class, 3L);
            System.out.println("Old user: " + targetUserToDelete.getName() + " | ID: " + targetUserToDelete.getId());
            System.out.println("Old e-mail: " + targetUserToDelete.getEmail());

            if (targetUserToDelete != null) {
                createEntityConnection.getConnectionDatabase().getTransaction().begin();
                createEntityConnection.getConnectionDatabase().remove(targetUserToDelete);
                createEntityConnection.getConnectionDatabase().getTransaction().commit();
                System.out.println("TestDeleteUser - main(): Selected user has been deleted from the database.");
                final User deletedUser = createEntityConnection.getConnectionDatabase().find(User.class, 3L);
                isSuccessDeleteUser = (deletedUser == null);
            }

        } catch (final Exception exception) {
            exception.printStackTrace();
            System.out.println("TestDeleteUser - main(): Attempt to delete the selected user from the database fails.");
        } finally {
            assertTrue(isSuccessDeleteUser);
            createEntityConnection.closeConnection();
            System.out.println("TestDeleteUser - main(): END");
        }
    }
}
