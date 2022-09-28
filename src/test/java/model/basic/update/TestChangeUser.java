package model.basic.update;

import model.basic.User;
import model.database.jpa.PersistenceEntityManager;

import java.util.Scanner;

public class TestChangeUser {

    public static void main(String[] args) {
        System.out.println("TestChangeUser - BEGIN");
        System.out.println("TestChangeUser - Insert the option to update (1 or 2): ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                firstOptionToUpdate();
                break;
            case 2:
                secondOptionToUpdate();
                break;
        }
        System.out.println("TestChangeUser - END");
    }

    private static void firstOptionToUpdate() {
        System.out.println("TestChangeUser - firstOptionToUpdate(): BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        createEntityConnection.createConnection();

        createEntityConnection.getConnectionDatabase().getTransaction().begin();
        final User updateUser = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
        System.out.println("Old user: " + updateUser.getName() + " | ID: " + updateUser.getId());
        System.out.println("Old e-mail: " + updateUser.getEmail());

        final String userNameUpdated = "Henrique Otogxm1";
        final String userEmailUpdated = "hen-otogxm1@icloud.com";

        System.out.println("User updated: ".concat(userNameUpdated));
        System.out.println("E-mail updated: ".concat(userEmailUpdated));
        updateUser.setName(userNameUpdated);
        updateUser.setEmail(userEmailUpdated);

        createEntityConnection.getConnectionDatabase().merge(updateUser);

        createEntityConnection.getConnectionDatabase().getTransaction().commit();
        createEntityConnection.closeConnection();
        System.out.println("TestChangeUser - firstOptionToUpdate(): END");
    }

    private static void secondOptionToUpdate() {
        System.out.println("TestChangeUser - secondOptionToUpdate(): BEGIN");
        PersistenceEntityManager createEntityConnection = new PersistenceEntityManager();
        createEntityConnection.createConnection();

        createEntityConnection.getConnectionDatabase().getTransaction().begin();
        final User updateUser = createEntityConnection.getConnectionDatabase().find(User.class, 1L);
        System.out.println("Old user: " + updateUser.getName() + " | ID: " + updateUser.getId());
        System.out.println("Old e-mail: " + updateUser.getEmail());

        final String letterRandom = generateRandomLetter();
        final String userNameUpdated = "Henrique Otog" + letterRandom + "m1";
        final String userEmailUpdated = "hen-otog" + letterRandom + "m1@icloud.com";

        System.out.println("User updated: ".concat(userNameUpdated));
        System.out.println("E-mail updated: ".concat(userEmailUpdated));
        updateUser.setName(userNameUpdated);
        updateUser.setEmail(userEmailUpdated);

//        A segunda opcao nao utiliza o metodo merge

        createEntityConnection.getConnectionDatabase().getTransaction().commit();
        createEntityConnection.closeConnection();
        System.out.println("TestChangeUser - secondOptionToUpdate(): END");
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
}
