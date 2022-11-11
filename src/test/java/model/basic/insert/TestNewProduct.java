package model.basic.insert;

import infrastructure.DataAccessObject;

import junit.framework.TestCase;
import model.basic.Product;

public class TestNewProduct extends TestCase {

    private static boolean isSuccessInsertNewProduct = false;

    public static void main(String[] args) {

        startTest();
    }

    private static void startTest() {
        System.out.println("TestNewProduct: BEGIN");
        final DataAccessObject<Product> dataAccessObject = new DataAccessObject<Product>(Product.class);
        try {
            final Product newProduct = new Product("Pen", 7.45);
            dataAccessObject.openTransactionalDAO();
            dataAccessObject.includeTransactionalDAO(newProduct);
            isSuccessInsertNewProduct = (dataAccessObject.getAllStorageItems().size() > 0);
            System.out.println("TestNewProduct - Added product - Name: " + newProduct.getName());
            System.out.println("TestNewProduct - Added product - ID: " + newProduct.getId());
        } catch ( final Exception exception) {
            exception.printStackTrace();
        } finally {
            assert(isSuccessInsertNewProduct);
            dataAccessObject.closeTransactionalDAO();
            dataAccessObject.closeConnectionDatabase();
            System.out.println("TestNewProduct: Product insertion performed successfully.");
            System.out.println("TestNewProduct: END");
        }
    }
}
