package model.basic.query;

import infrastructure.DataAccessObject;
import junit.framework.TestCase;
import model.onetomany.ItemFromOrder;
import model.onetomany.RestaurantOrder;

public class TestGetOrders extends TestCase {

    private static boolean isSuccessGetOrder = false;

    public static void main(String[] args) { startTest(); }

    public static void startTest() {
        System.out.println("TestGetOrders: BEGIN");
        try {
            DataAccessObject<RestaurantOrder> dataAccessObject = new DataAccessObject<>(RestaurantOrder.class);
            try {
                final RestaurantOrder restaurantOrder = dataAccessObject.getStorageItemById(1L);
                for(ItemFromOrder itemFromOrder: restaurantOrder.getItemsFromOrder()) {
                    System.out.println("TestGetOrders - itemFromOrder.getQuantity(): " + itemFromOrder.getQuantity());
                }
                isSuccessGetOrder = true;
            } catch (final Exception queryException) {
                queryException.printStackTrace();
                throw new RuntimeException(queryException);
            } finally {
                assertTrue(isSuccessGetOrder);
                dataAccessObject.closeConnectionDatabase();
                System.out.println("TestGetOrders: END");
            }
        } catch (final Exception connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException(connectionException);
        }
    }
}
