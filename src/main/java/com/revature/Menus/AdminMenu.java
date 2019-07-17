package com.revature.Menus;

import java.util.Scanner;
import com.revature.Models.*;
import com.revature.Util.*;
import java.util.List;
import java.util.ArrayList;
import com.revature.Entities.*;

public class AdminMenu extends EmployeeMenu {

    ConnectionUtil connectionUtil = new ConnectionUtil();
    Account account = new Account();
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
                this.displayAll();
                break;
            case "2":
                System.out.println("Enter the username for the accounts you want to view");
                String username = s.next();
                user.setUsername(username);
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
}