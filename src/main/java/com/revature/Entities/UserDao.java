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
                PreparedStatement pStatement = connection.prepareStatement("insert into users(username, password, name, permission) values(?, ?, ?, ?)");
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
                PreparedStatement pStatement = connection.prepareStatement("insert into users(username, password, permission) values(?, ?, ?)");
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

    public User getUserInfo(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try{
            PreparedStatement pStatement = connection.prepareStatement("select * from users where username=? and password=?");
            pStatement.setString(1, user.username);
            pStatement.setString(2, user.password);
            ResultSet resultset = pStatement.executeQuery();
            resultset.next();
            user.setName(resultset.getString("name"));
            user.setPermission(resultset.getInt("permission"));
            return user;
        } catch (SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
        
        
    }

    public boolean checkExistingUser(String username){
        User user = new User();
        user.username = username;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from users where username=?");
            pStatement.setString(1, user.getUsername());
            ResultSet resultset = pStatement.executeQuery();
            if (resultset.next()){
                return true;
            }else{return false;}
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println("Cannot detirmine existance of user, assume user doesnt exist and try a new username");
            return false;
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