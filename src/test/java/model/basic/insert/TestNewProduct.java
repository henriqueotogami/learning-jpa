package model.basic.insert;

import infrastructure.DataAccessObject;

import model.basic.Product;

public class TestNewProduct {

    public static void main(String[] args) {

        Product newProduct = new Product("Pen", 7.45);

        final DataAccessObject<Product> dataAccessObject = new DataAccessObject<Product>(Product.class);
//        final String createTableSqlCommand =
//                "CREATE TABLE IF NOT EXISTS table_product ("
//                        + "product_id INT AUTO_INCREMENT PRIMARY KEY,"
//                        + "product_name VARCHAR(200) NOT NULL,"
//                        + "product_price DOUBLE(11,2) NOT NULL"
//                        + ")";
//        dataAccessObject.createTable("table_product", createTableSqlCommand);
        dataAccessObject.openTransactionalDAO().includeTransactionalDAO(newProduct).closeTransactionalDAO().closeConnectionDatabase();

        System.out.println("Product ID: " + newProduct.getId());
    }
}
