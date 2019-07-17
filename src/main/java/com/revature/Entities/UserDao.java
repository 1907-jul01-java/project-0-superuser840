package com.revature.Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.Models.User;
//import com.revature.Util.ConnectionUtil;

/**
 * MovieDao
 */
public class UserDao implements Dao<User> {
    Connection connection;

    @Override
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

    @Override
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
                user.setName(resultSet.getString("name"));
                user.setPermission(resultSet.getInt("permission"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    public User getUserInfo(String username){
        User user = new User();
        user.username = username;
        try{
            PreparedStatement pStatement = connection.prepareStatement("select * from users where username=?");
            pStatement.setString(1, user.username);
            ResultSet resultset = pStatement.executeQuery();
            user.setName(resultset.getString("name"));
            user.setPermission(resultset.getInt("permission"));
            user.setPassword(resultset.getString("password"));
            return user;
        } catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        
        
    }

    public boolean checkExistingUser(String username, String password){
        User user = new User();
        user.username = username;
        user.password = password;
        try {
            System.out.println("Actual first chekcpoint?");
            PreparedStatement pStatement = connection.prepareStatement("select * from users where username=? and password=?");
            System.out.println("First Checkpoin");/////////////////////////
            pStatement.setString(1, user.getUsername());
            pStatement.setString(2, user.getPassword());
            int exists = pStatement.executeUpdate();
            System.out.println("Second Checkpoint");/////////////////////////
            if (exists==1){
                return true;
            }else{return false;}
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.out.println("Cannot detirmine existance of user, assume true and try a new username");
            return true;
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("update users set password=?, name=? where username=?");
            pStatement.setString(1, user.getPassword());
            pStatement.setString(2, user.getName());
            pStatement.setString(3, user.getUsername());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
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

    public UserDao(Connection connection) {
        this.connection = connection;
    }
}