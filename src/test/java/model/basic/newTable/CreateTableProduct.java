package model.basic.newTable;

import junit.framework.TestCase;
import model.database.jdbc.DatabaseConnectivityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableProduct extends TestCase {

    private static boolean isSuccessCreateTableProduct = false;

    public static void main(String[] args) throws SQLException {

        startTest();
    }

    private static void startTest() throws SQLException {
        System.out.println("CreateTableProduct: BEGIN");
        Connection factoryConnection = DatabaseConnectivityManager.getConnection();
        try {
            final String createTableSqlCommand =
                    "CREATE TABLE IF NOT EXISTS table_product ("
                            + "product_id INT AUTO_INCREMENT PRIMARY KEY,"
                            + "product_name VARCHAR(200) NOT NULL,"
                            + "product_price DOUBLE(11,2) NOT NULL"
                            + ")";

            Statement factoryStatement = factoryConnection.createStatement();
            isSuccessCreateTableProduct = factoryStatement.execute(createTableSqlCommand);

        } catch (final Exception exception){
            exception.printStackTrace();
        } finally {
            assertTrue(isSuccessCreateTableProduct);
            factoryConnection.close();
            System.out.println("CreateTableProduct: Product table created successfully.");
            System.out.println("CreateTableProduct: END");
        }
    }
}
