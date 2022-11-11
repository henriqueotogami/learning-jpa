package model.basic.query;

import infrastructure.ProductDAO;
import junit.framework.TestCase;
import model.basic.Product;

import java.util.List;
import java.util.function.BinaryOperator;

public class TestGetProducts extends TestCase {

    private static boolean isSuccessGetProducts = false;

    public static void main(String[] args) {

        startTest();
    }

    public static void startTest() {
        System.out.println("TestGetProducts: BEGIN");
        try {
            final ProductDAO productDAO = new ProductDAO();
            final List<Product> allProducts = productDAO.getAllStorageItems();

            for (Product product : allProducts) {
                System.out.println("TestGetProducts - ID: " + product.getId());
                System.out.println("TestGetProducts - Name: " + product.getName());
            }

            final BinaryOperator<Double> sumFunction = ((totalPrice, singlePrice) -> totalPrice + singlePrice);
            final Double minimumPrice = 0.0D;
            final double totalProductsPrice =
                    allProducts.stream().map(product -> product.getPrice()).reduce(minimumPrice, sumFunction).doubleValue();

            System.out.println("TestGetProducts - Total products price: R$ " + totalProductsPrice);
            isSuccessGetProducts = true;
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessGetProducts);
            System.out.println("TestGetProducts: Product query performed successfully.");
            System.out.println("TestGetProducts: END");
        }
    }
}
