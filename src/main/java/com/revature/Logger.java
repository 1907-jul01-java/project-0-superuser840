package com.revature;

import com.revature.Entities.UserDao;
import com.revature.Util.ConnectionUtil;
import com.revature.Models.*;
import java.util.Scanner;

public class Logger {

    public void logAction(int action) {
        try (Scanner input = new Scanner(System.in)) {
            ConnectionUtil connectionUtil = new ConnectionUtil();
            UserDao userdao = new UserDao(connectionUtil.getConnection());
            if (action == 1) {
                // attempt to log in
                User user = new User();
                while (true) {
                    System.out.println("Enter a username and password to login!");
                    System.out.println("Username: ");
                    user.username = input.nextLine().toLowerCase();
                    System.out.println("Password: ");
                    user.password = input.nextLine();
                    if (userdao.checkExistingUser(user.username, user.password) == true) {
                        System.out.println("Welcome " + user.username);
                        user = userdao.getUserInfo(user.username);
                        System.out.println(user.toString()); /// Temporary print statement to verify user info is
                                                             /// grabbed
                        switch (user.getPermission()){
                            case 1:
                            //Perform Customer transactions
                            break;
                            case 2:
                            //Perform Employee transactions
                            break;
                            case 3:
                            //Perform Admin interactions
                            break;
                        }
                    } else {
                        System.out.println("Username or password didnt match, please try again");
                    }
                }

            } else if (action == 2) {
                // Create new user
                User user = new User();
                System.out.println("To create a new account, enter a username, password, and your name");
                System.out.println("Username: ");
                user.username = input.nextLine().toLowerCase();
                System.out.println("Password: ");
                user.password = input.nextLine();
                System.out.println("Your full name: ");
                user.name = input.nextLine().toLowerCase();
                System.out.println("Are you a customer(1), employee(2) or admin(3): ");
                try {
                    user.permission = input.nextInt();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                userdao.insert(user);

            } else {
                System.out.println("Input a valid action");
            }
            connectionUtil.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}