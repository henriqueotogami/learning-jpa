package model.create;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CreateDataBaseFactoryConnection {

    public static Connection getConnection(){
        try {
            final Properties factoryProperties = getProperties();
            final String addressJdbcConnection = factoryProperties.getProperty("database.url");
            final String userJdbcConnection = factoryProperties.getProperty("database.user");
            final String passwordJdbcConnection = factoryProperties.getProperty("database.password");

            Connection connectionDriverManager =
                    DriverManager.getConnection(addressJdbcConnection, userJdbcConnection, passwordJdbcConnection);
            System.out.println("Connection made successfully.");
            return connectionDriverManager;
        } catch (SQLException | IOException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String fileDirectory = "/connection.properties";
        properties.load(CreateDataBaseFactoryConnection.class.getResourceAsStream(fileDirectory));
        return properties;
    }
}
