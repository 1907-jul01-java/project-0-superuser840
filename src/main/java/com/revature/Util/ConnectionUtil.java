package com.revature.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionUtil
 */
public class ConnectionUtil {
    private Connection connection;
    private String url, user, password;

    public ConnectionUtil() {
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")){
            Properties properties = new Properties();
            //properties.load(new FileReader("application.properties"));
            this.url = properties.getProperty("url");
            this.user = properties.getProperty("user");
            this.password = properties.getProperty("password");
            System.out.println("failes at drivermanager");
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Succedes");
        } catch (SQLException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}