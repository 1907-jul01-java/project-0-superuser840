package com.revature;

import com.revature.Entities.UserDao;
import com.revature.Util.ConnectionUtil;
import com.revature.Models.*;
import java.util.Scanner;
import com.revature.Menus.*;

public class Logger {

    public void logAction(String action, Scanner s) {
        try {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            UserDao userdao = new UserDao(connectionUtil.getConnection());
            if (action.equals("1")) {
                // attempt to log in
                User user = new User();

                do {
                    System.out.println("\nEnter a username and password to login");
                    System.out.print("Username: ");
                    user.username = s.next().toLowerCase();
                    System.out.print("Password: ");
                    user.password = s.next();
                    if (userdao.checkExistingUser(user.username) == true) {
                        user = userdao.getUserInfo(user.username, user.password);

                        switch (user.getPermission()) {
                        case 1:
                            // goto customer menu
                            CustomerMenu custmenu = new CustomerMenu();
                            custmenu.operate(user, s);
                            break;
                        case 2:
                            // goto employee menu
                            //EmployeeMenu employeemenu = new EmployeeMenu(user, s);
                            break;
                        case 3:
                            // goto admin menu
                            //AdminMenu adminmenu = new AdminMenu(user, s);
                            break;
                        }
                    } else {
                        System.out.println("Username or password didnt match, please try again");
                    }
                    System.out.println("Type 'exit' to go back");
                } while (!s.next().equalsIgnoreCase("exit"));
            } else if (action.equals("2")) {
                // Create new user
                User user = new User();
                System.out.println("To create a new account, enter a username, password, and your name");
                System.out.print("Username: ");
                user.username = s.next().toLowerCase();
                System.out.print("Password: ");
                user.password = s.next();
                System.out.print("Your full name: ");
                user.name = s.next().toLowerCase();
                System.out.println("Are you a customer(1), employee(2) or admin(3): ");
                try {
                    user.setPermission(s.nextInt());
                    System.out.println(user.permission);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    System.out.println("cannot set int");
                }
                userdao.insert(user);
                System.out.println(user);

            } else {
                System.out.println("Input a valid action\n");
            }
            connectionUtil.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}