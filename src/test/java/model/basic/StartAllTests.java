package model.basic;

import model.basic.delete.TestDeleteUser;
import model.basic.insert.TestNewProduct;
import model.basic.insert.TestNewUser;
import model.basic.newTable.CreateTableProduct;
import model.basic.query.TestGetProducts;
import model.basic.query.TestGetUser;
import model.basic.query.TestGetUsers;
import model.basic.update.TestChangeUser;

import java.sql.SQLException;

public class StartAllTests {

    public static void main(String[] args) throws SQLException {

        TestNewProduct.startTest();
        TestNewUser.startTest();


        TestGetProducts.startTest();
        TestGetUser.startTest();

        TestChangeUser.startTest();

        TestDeleteUser.startTest();
    }
}
