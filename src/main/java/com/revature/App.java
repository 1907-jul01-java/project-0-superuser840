package com.revature;

import com.revature.Util.*;
import java.util.Scanner;
import com.revature.Logger;

public class App {
    public void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {

            int logaction = 0;
            Logger login = new Logger();
            while (true) {
                System.out.println("Press 1 to sign in \nPress 2 to create a new account\n Press 0 to exit\n");
                logaction = scanner.nextInt();
                if (logaction == 0) {
                    break;
                } else {
                    login.logAction(logaction);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
