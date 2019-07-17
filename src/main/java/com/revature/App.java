package com.revature;

//import com.revature.Util.*;
import java.util.Scanner;
import com.revature.Logger;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        String action;
        try (Scanner s = new Scanner(System.in);) {
            Logger login = new Logger();
            while (true){
                
                System.out.println("\nPress 1 to sign in \nPress 2 to create a new account\nEnter exit to exit\n");
                try {
                    action = s.next();
                    if (action.equalsIgnoreCase("exit")){
                        break;
                    }

                    switch (action) {
                    case "0":
                        break;
                    case "1":
                        login.logAction(action, s);
                        break;
                    case "2":
                        login.logAction(action, s);
                        break;
                    default:
                        System.out.println("\nNot a valid input, please enter a valid number\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("input not accepted, please enter a valid input\n");
                }catch (Exception e){

                }
             } 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed at App exception");
        }
    }
    
}
