package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionUtil
 */
public class ConnectionUtil {
    private Connection connection;
    private String url, user, password;

    public ConnectionUtil() {
        try {
            this.url = "jdbc:postgresql://192.168.99.100:5432/bankdb";
            this.user = "bankdb";
            this.password = "bankdb";
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch(Exception e){
            e.getStackTrace();
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