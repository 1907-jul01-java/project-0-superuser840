package com.revature.Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.Models.*;
//import com.revature.Util.ConnectionUtil;

/**
 * MovieDao
 */
public class EmployeeDao  {
    Connection connection;

  
    public void insert(User user) {
        if (user.name != null){
            try {
                PreparedStatement pStatement = connection.prepareStatement("insert into users(username, password, name, permissions) values(?, ?, ?, ?)");
                pStatement.setString(1, user.getUsername());
                pStatement.setString(2, user.getPassword());
                pStatement.setString(3, user.getName());
                pStatement.setInt(4, user.getPermission());
                pStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }else{
            try {
                PreparedStatement pStatement = connection.prepareStatement("insert into users(username, password, permissions) values(?, ?, ?)");
                pStatement.setString(1, user.getUsername());
                pStatement.setString(2, user.getPassword());
                pStatement.setInt(4, user.getPermission());
                pStatement.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public List<User> getAll() {
        User user;
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("First Name"));
                user.setPermission(resultSet.getInt("Permission"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }


    public void update(Account account) {
        try {
            PreparedStatement pStatement = connection
                    .prepareStatement("update accounts set permission=? where accountnumber=?");
            pStatement.setInt(1, account.getPermission());
            pStatement.setInt(2, account.getAccountNumber());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }



    public void delete(User user) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("delete from users where username=?");
            pStatement.setString(1, user.getUsername());
            pStatement.setString(2, user.getName());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }
}