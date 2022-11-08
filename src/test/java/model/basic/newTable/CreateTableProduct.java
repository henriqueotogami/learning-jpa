package model.basic.newTable;

import model.database.jdbc.DatabaseConnectivityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableProduct {

    public static void main(String[] args) throws SQLException {

        Connection factoryConnection = DatabaseConnectivityManager.getConnection();
        final String createTableSqlCommand =
                "CREATE TABLE IF NOT EXISTS table_product ("
                        + "product_id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "product_name VARCHAR(200) NOT NULL,"
                        + "product_price DOUBLE(11,2) NOT NULL"
                        + ")";


        Statement factoryStatement = factoryConnection.createStatement();
        factoryStatement.execute(createTableSqlCommand);

        System.out.println("Product table created successfully.");
        factoryConnection.close();
    }
}
