package com.revature.Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.revature.Models.Account;
//import com.revature.Util.ConnectionUtil;

/**
 * AccountDao
 */
public class AdminDao implements Dao<Account> {
    Connection connection;

    @Override
    public void insert(Account account) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into accounts values (nextval('account_seq'), ?, ?, ?, ?");
            pStatement.setInt(1, account.getBalance());
            pStatement.setInt(2, account.getAccountType());
            pStatement.setBoolean(3, account.isApproved());
            pStatement.setInt(4, account.getPermission());
            pStatement.setString(5, account.getUsername());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Account> getAll() {
        Account account;
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from accounts");
            while (resultSet.next()) {
                account = new Account();
                account.setBalance(resultSet.getInt("balance"));
                account.setAccountType(resultSet.getInt("accounttype"));
                account.setApproved(resultSet.getBoolean("approved"));
                account.setAccountNumber(resultSet.getInt("accountnumber"));
                account.setAccountOwner(resultSet.getString("accountowner"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return accounts;
    }

    public Account getAccount(String accountowner){
        Account account = new Account();
        account.accountOwner = accountowner;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select * from accounts where accountowner=" + account.accountOwner);
            account.setAccountNumber(resultset.getInt("accountnumber"));
            account.setBalance(resultset.getInt("balance"));
            account.setAccountType(resultset.getInt("accounttype"));
            account.setApproved(resultset.getBoolean("approved"));
            return account;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void update(Account account) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("update accounts set balance=? where accountowner=? and accounttype=?");
            pStatement.setInt(1, account.getBalance());
            pStatement.setString(2, account.getAccountOwner());
            pStatement.setInt(3, account.getAccountType());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void delete(Account account) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("delete from accounts where accountowner=? and accounttype=?");
            pStatement.setString(1, account.getAccountOwner());
            pStatement.setInt(2, account.getAccountType());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public AdminDao(Connection connection) {
        this.connection = connection;
    }
}