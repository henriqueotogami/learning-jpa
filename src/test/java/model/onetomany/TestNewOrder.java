package model.onetomany;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.basic.Product;
import model.onetomany.ItemFromOrder;
import model.onetomany.RestaurantOrder;

public class TestNewOrder extends TestCase {

    private static boolean isSuccessNewOrder = false;

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        System.out.println("TestNewOrder: BEGIN");
        try {
            DataAccessObject<Object> dataAccessObject = new DataAccessObject<>();
            try {
                final RestaurantOrder restaurantOrder = new RestaurantOrder();
                final Product product = new Product("Geladeira", 2789.99);
                final ItemFromOrder itemFromOrder = new ItemFromOrder(restaurantOrder, product, 10);
                dataAccessObject
                        .openTransactionalDAO()
                        .includeTransactionalDAO(product)
                        .includeTransactionalDAO(restaurantOrder)
                        .includeTransactionalDAO(itemFromOrder)
                        .closeTransactionalDAO();
                isSuccessNewOrder = true;
            } catch (Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessNewOrder);
                dataAccessObject.closeConnectionDatabase();
                System.out.println("TestNewOrder: END");
            }

        } catch (Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }

    }
}
