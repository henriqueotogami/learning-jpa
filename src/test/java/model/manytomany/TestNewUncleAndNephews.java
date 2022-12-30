package model.basic.manytomany;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.manytomany.Nephew;
import model.manytomany.Uncle;

public class TestNewUncleAndNephews extends TestCase {

    private static boolean isSuccessAddNewUncleAndNephews = false;

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        System.out.println("TestNewUncleAndNephews: BEGIN");
        try {
            DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();
            try {
                final Uncle aunt = new Uncle("Mariah");
                final Uncle uncle = new Uncle("John");
                final Nephew niece = new Nephew("Jane");
                final Nephew nephew = new Nephew("Alex");

                aunt.getNephewsList().add(nephew);
                aunt.getNephewsList().add(niece);
                uncle.getNephewsList().add(nephew);
                uncle.getNephewsList().add(niece);

                nephew.getUnclesList().add(aunt);
                nephew.getUnclesList().add(uncle);
                niece.getUnclesList().add(aunt);
                niece.getUnclesList().add(uncle);

                dataAccessObject
                        .openTransactionalDAO()
                        .includeTransactionalDAO(aunt)
                        .includeTransactionalDAO(uncle)
                        .includeTransactionalDAO(nephew)
                        .includeTransactionalDAO(niece)
                        .closeTransactionalDAO();

                isSuccessAddNewUncleAndNephews = true;
            } catch (final Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessAddNewUncleAndNephews);
                dataAccessObject.closeConnectionDatabase();
                System.out.println("TestNewUncleAndNephews: END");
            }
        } catch (final Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }
}
