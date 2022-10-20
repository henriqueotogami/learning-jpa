package model.basic.query;

import infrastructure.ProductDAO;
import model.basic.Product;

import java.util.List;
import java.util.function.BinaryOperator;

public class TestGetProducts {

    public static void main(String[] args) {

        final ProductDAO productDAO = new ProductDAO();
        final List<Product> allProducts = productDAO.getAllStorageItems();

        for(Product product : allProducts) {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
        }


        final BinaryOperator<Double> sumFunction = ((totalPrice, singlePrice) -> totalPrice + singlePrice);
        final Double minimumPrice = 0.0D;
        final double totalProductsPrice =
                allProducts.stream().map(product -> product.getPrice()).reduce(minimumPrice, sumFunction).doubleValue();

        System.out.println("Total products price: R$ " + totalProductsPrice);
    }
}
