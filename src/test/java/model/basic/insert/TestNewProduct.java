package model.basic.insert;

import infrastructure.DataAccessObject;

import model.basic.Product;

public class TestNewProduct {

    public static void main(String[] args) {

        Product newProduct = new Product("Pen", 7.45);

        final DataAccessObject<Product> dataAccessObject = new DataAccessObject<Product>(Product.class);

        dataAccessObject.openTransactionalDAO();
        dataAccessObject.includeTransactionalDAO(newProduct);
        dataAccessObject.closeTransactionalDAO();
        dataAccessObject.closeConnectionDatabase();

        System.out.println("Product ID: " + newProduct.getId());
    }
}
