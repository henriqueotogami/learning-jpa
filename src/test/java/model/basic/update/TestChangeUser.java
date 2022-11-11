package model.basic.update;

import junit.framework.TestCase;
import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

import java.util.Scanner;

public class TestChangeUser extends TestCase {

    private static boolean isSuccessUserUpdated = false;

    public static void main(String[] args) {
        startTest();
    }

    public static void startTest() {
        System.out.println("TestChangeUser - BEGIN");
        try {
            System.out.println("TestChangeUser - Insert the option to update (1 | 2 | 3): ");
            Scanner userTyped = new Scanner(System.in);
//            switch (userTyped.nextInt()) {
//                case 1:
//                    firstOptionToUpdate();
//                    break;
//                case 2:
//                    secondOptionToUpdate();
//                    break;
//                case 3:
//                    thirdOptionToUpdate();
//                    break;
//            }
            firstOptionToUpdate();
            secondOptionToUpdate();
            thirdOptionToUpdate();
        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
        System.out.println("TestChangeUser - END");
        }
    }

    private static void firstOptionToUpdate() {
        System.out.println("TestChangeUser - firstOptionToUpdate(): BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        try {

            createEntityConnection.createConnection();
            createEntityConnection.getConnectionDatabase().getTransaction().begin();

            final User targetUserToUpdate = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            System.out.println("Old user: " + targetUserToUpdate.getName() + " | ID: " + targetUserToUpdate.getId());
            System.out.println("Old e-mail: " + targetUserToUpdate.getEmail());

            final String userNameUpdated = "Henrique Otogxm1";
            final String userEmailUpdated = "hen-otogxm1@icloud.com";
            System.out.println("User updated: ".concat(userNameUpdated));
            System.out.println("E-mail updated: ".concat(userEmailUpdated));

            targetUserToUpdate.setName(userNameUpdated);
            targetUserToUpdate.setEmail(userEmailUpdated);

            createEntityConnection.getConnectionDatabase().merge(targetUserToUpdate);
            createEntityConnection.getConnectionDatabase().getTransaction().commit();

            final User userUpdated = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            isSuccessUserUpdated = userUpdated.getName().equals(userNameUpdated);
        } catch (final Exception exception) {
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessUserUpdated);
            createEntityConnection.closeConnection();
            System.out.println("TestChangeUser - firstOptionToUpdate(): User Update Successfully Performed.");
            System.out.println("TestChangeUser - firstOptionToUpdate(): END");
        }
    }

    private static void secondOptionToUpdate() {
        System.out.println("TestChangeUser - secondOptionToUpdate(): BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        try {

            createEntityConnection.createConnection();
            createEntityConnection.getConnectionDatabase().getTransaction().begin();

            final User targetUserToUpdate = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            System.out.println("Old user: " + targetUserToUpdate.getName() + " | ID: " + targetUserToUpdate.getId());
            System.out.println("Old e-mail: " + targetUserToUpdate.getEmail());

            final String letterRandom = generateRandomLetter();
            final String userNameUpdated = "Henrique Otog" + letterRandom + "m1";
            final String userEmailUpdated = "hen-otog" + letterRandom + "m1@icloud.com";

            System.out.println("User updated: ".concat(userNameUpdated));
            System.out.println("E-mail updated: ".concat(userEmailUpdated));
            targetUserToUpdate.setName(userNameUpdated);
            targetUserToUpdate.setEmail(userEmailUpdated);

//        A segunda opcao nao utiliza o metodo merge

            createEntityConnection.getConnectionDatabase().getTransaction().commit();
            final User userUpdated = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            isSuccessUserUpdated = userUpdated.getName().equals(userNameUpdated);
        } catch ( final Exception exception){
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessUserUpdated);
            createEntityConnection.closeConnection();
            System.out.println("TestChangeUser - secondOptionToUpdate(): User Update Successfully Performed.");
            System.out.println("TestChangeUser - secondOptionToUpdate(): END");
        }
    }

    private static String generateRandomLetter(){

        final String[] ALPHABET =
                { "A", "B", "C", "D", "E",
                  "F", "G", "H", "I",
                  "J", "K", "L", "M",
                  "N", "O", "P", "Q",
                  "R", "S", "T", "U",
                  "V", "W", "X", "Y", "Z" };

        int letterIndexRandom = (int) (Math.random() * (ALPHABET.length-1));
        return ALPHABET[letterIndexRandom];
    }

    private static void thirdOptionToUpdate(){

        System.out.println("TestChangeUser - thirdOptionToUpdate(): BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        try {
            createEntityConnection.createConnection();
            createEntityConnection.getConnectionDatabase().getTransaction().begin();

            final User targetUserToUpdate = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            System.out.println("Old user: " + targetUserToUpdate.getName() + " | ID: " + targetUserToUpdate.getId());
            System.out.println("Old e-mail: " + targetUserToUpdate.getEmail());

//        A terceira opcao utiliza o método de "destacar" o usuario atual do banco de dados
//        para inserir um novo usuario atualizado no mesmo lugar.
            createEntityConnection.getConnectionDatabase().detach(targetUserToUpdate);


            final String letterRandom = generateRandomLetter();
            final String userNameUpdated = "Henrique Otog" + letterRandom + "m1";
            final String userEmailUpdated = "hen-otog" + letterRandom + "m1@icloud.com";

            System.out.println("User updated: ".concat(userNameUpdated));
            System.out.println("E-mail updated: ".concat(userEmailUpdated));
            targetUserToUpdate.setName(userNameUpdated);
            targetUserToUpdate.setEmail(userEmailUpdated);

            createEntityConnection.getConnectionDatabase().getTransaction().commit();
            final User userUpdated = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
            isSuccessUserUpdated = userUpdated.getName().equals(userNameUpdated);
        } catch ( final Exception exception) {
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessUserUpdated);
            createEntityConnection.closeConnection();
            System.out.println("TestChangeUser - thirdOptionToUpdate(): User Update Successfully Performed.");
            System.out.println("TestChangeUser - thirdOptionToUpdate(): END");
        }
    }
}
