package com.revature.Menus;

import java.util.Scanner;
import com.revature.Models.User;
import com.revature.Models.Account;
import com.revature.Util.*;
import java.util.List;
import java.util.ArrayList;
import com.revature.Entities.*;

public class EmployeeMenu extends CustomerMenu {

    ConnectionUtil connectionUtil = new ConnectionUtil();
    EmployeeDao employeeDao = new EmployeeDao(connectionUtil.getConnection());
    Account account = new Account();

    @Override
    public void operate(User user, Scanner s) {

        String accessOperation;
        boolean loop = true;
        do {
            if (user.name != null) {
                System.out.println("\nWelcome " + user.name);
            } else {
                System.out.println("\nWelcome " + user.username);
            }
            System.out.println(
                    "1. Display all existing Users/s\n2. Display customers account/s\n3. Approve an account\n4. Exit\n");
            accessOperation = s.next();
            switch (accessOperation) {
            case "1":
                this.displayAll(user, s);
                break;
            case "2":
                System.out.println("Enter the username for the accounts you want to view");
                this.displayAccounts(user, s);
                break;
            case "3":
                this.setApproved(user, s);
                break;
            case "4":
                loop = false;
                break;
            }
        } while (loop);

    }

    public void setApproved(User user, Scanner s) {

        System.out.println("Enter the account number you want to approve");
        int actNo = s.nextInt();
        account = customerDao.grabAccount(actNo);
        employeeDao.update(account);
    }

    public void displayAll(User user, Scanner s) {
        employeeDao.getAll();
    }
}