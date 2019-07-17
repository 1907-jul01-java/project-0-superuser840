package com.revature.Menus;

import com.revature.Models.User;
import java.util.Scanner;
import com.revature.Models.Account;
import com.revature.Entities.CustomerDao;
import com.revature.Util.*;

public class CustomerMenu {

    ConnectionUtil connectionUtil = new ConnectionUtil();
    CustomerDao customerDao = new CustomerDao(connectionUtil.getConnection());

    public void operate(User user, Scanner s) {

        String accessOperation;
        boolean loop = true;
        do {
            System.out.println("1. Create new account\n2. access existing account/s\n3. Exit\n");
            accessOperation = s.next();
            switch (accessOperation) {
            case "1":
                this.newAccount(user, s);
                break;
            case "2":
                this.accessAccounts(user, s);
                break;
            case "3":
                loop = false;
                break;
            }
        } while (loop);

    }

    public void newAccount(User user, Scanner s) {
        Account account = new Account();
        System.out.println("Start account application");
        System.out.println("Enter initial deposit balance?");
        account.balance = s.nextDouble();
        System.out.println("Checking or Savings?");
        account.accountType = s.nextInt();
        account.approved = false;
        account.permission = 1;
        account.setAccountOwner(user.username);
        customerDao.insert(account);
    }

    public void accessAccounts(User user, Scanner s) {
        customerDao.getUserAccounts(user.username);
    }

}