package com.revature;

//import com.revature.Util.*;
import java.util.Scanner;
import com.revature.Logger;

public class App {
    public static void main(String[] args) {
        int logAction;
        try (Scanner scanner = new Scanner(System.in);){
             

            Logger login = new Logger();
            while (true) {
                System.out.println("Press 1 to sign in \nPress 2 to create a new account\nPress 0 to exit\n");
                logAction = scanner.nextInt();
                if (logAction == 0) {
                    break;
                } else {
                    login.logAction(logAction);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed at App exception");
        }
    }
}
