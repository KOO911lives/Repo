/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapplication;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class ChatApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
     MASSAGES MESS = new MASSAGES();
        Login_1 log = new Login_1();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter username:");
        
        String username = scanner.nextLine();
        
        if (log.checkUsername(username)) {
            System.out.println("correct");
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            
            if (log.checkPasswordComplexity(password)) {
                System.out.println("correct");
                System.out.println("Enter phone number:");
                String regex = scanner.nextLine();
                
                if (log.checkCellPhoneNumber(regex)) {
                    System.out.println("Phone number is correct");
                    System.out.println("Welcome back to the chatapp");
                    System.out.println("Enter the username you have registered in with:");
                    String newUser = scanner.nextLine();
                    System.out.println("Enter the password you have registered in with:");
                    String newPass = scanner.nextLine();
                    
                    if (log.loginUser(username, password, newUser, newPass)) {
                        System.out.println("Login successfull");
                        MESS.part();
                    } else {
                        System.out.println("Login unsuccessful");
                    }
                } else {
                    System.out.println("Incorrect phone number format");
                }
            } else {
                System.out.println("Incorrect password complexity");
            }
        } else {
            System.out.println("Incorrect username format");
        }
}
}
