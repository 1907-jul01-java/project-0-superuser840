package com.revature.Menus;

import com.revature.Models.User;
import com.revature.Actor.Customer;
import java.util.Scanner;
import com.revature.Models.Account;
import com.revature.Entities.CustomerDao;
import com.revature.Util.*;
import java.util.List;
import java.util.ArrayList;

public class CustomerMenu {

    ConnectionUtil connectionUtil = new ConnectionUtil();
    CustomerDao customerDao = new CustomerDao(connectionUtil.getConnection());

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
                    "1. Create new account\n2. Display existing account/s\n3. Operate on account/s\n4. Exit\n");
            accessOperation = s.next();
            switch (accessOperation) {
            case "1":
                this.newAccount(user, s);
                break;
            case "2":
                this.displayAccounts(user, s);
                break;
            case "3":
                this.accessAccounts(user, s);
                break;
            case "4":
                loop = false;
                break;
            }
        } while (loop);

    }

    public void newAccount(User user, Scanner s) {
        Account account = new Account();
        System.out.println("Start account application");
        System.out.println("Enter initial deposit balance?");
        System.out.print("$");
        account.balance = s.nextDouble();
        System.out.println("Checking(1) or Savings(2)?");
        account.accountType = s.nextInt();
        account.approved = false;
        account.permission = 1;
        account.setAccountOwner(user.username);
        customerDao.insert(account);
    }

    public void displayAccounts(User user, Scanner s) {
        List<Account> accounts = new ArrayList<>();
        accounts = customerDao.getUserAccounts(user.username);
        System.out.println(accounts.toString());
    }

    public void accessAccounts(User user, Scanner s) {

        double amount;
        int accountno;
        Customer customer = new Customer();

        System.out.println("\n1. Withdrawl\n2. Deposit\n3. Transfer\n");
        int action = s.nextInt();
        switch (action) {
        case 1:
            System.out.print("Enter the account number you want to withdrawl from: ");
            accountno = s.nextInt();
            System.out.print("Enter quantity to Withdrawl: ");
            amount = s.nextDouble();
            customer.Withdrawl(amount, accountno);
            break;
        case 2:
            System.out.print("Enter the account number you want to Deposit to: ");
            accountno = s.nextInt();
            System.out.print("Enter quantity to Deposit: ");
            amount = s.nextDouble();
            customer.Deposit(amount, accountno);
            break;
        case 3:
            int accountNo2;
            System.out.print("Enter the account number you want to Withdrawl from: ");
            accountno = s.nextInt();
            System.out.print("Enter the account number you want to Transfer money to");
            accountNo2 = s.nextInt();
            System.out.print("Enter quantity to Transfer: ");
            amount = s.nextDouble();
            customer.Transfer(amount, accountno, accountNo2);
            break;
        }
    }

}