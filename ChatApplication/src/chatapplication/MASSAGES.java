/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class MASSAGES {
      static Login_1 log = new Login_1();
    private static int totalMessagesSent = 0; 

    public void part() {
        int option;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("\nWelcome to QuickChat");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");
            
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1 -> sendMessages();
                case 2 -> System.out.println("Coming soon");
                case 3 -> System.out.println("Thanks for using QuickChat");
                default -> System.out.println("error!! invalid input");
            }
        } while (option != 3);
    }

   
    public static String generateMessageID() {
        Random ran = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(ran.nextInt(10));
        }
        return id.toString();
    }

    
    public static String generateMessageHash(String messageID, int messageNumber, String messageText) {
        String firstTwoID = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String combinedWords = (firstWord + lastWord).toUpperCase();
        return firstTwoID + ":" + messageNumber + ":" + combinedWords;
    }

   
    public static boolean checkMessageLength(String message) {
        return message.length() <= 250;
    }

    public static void sendMessages() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many messages do you want to send: ");
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Message " + (i + 1) + " of " + n + " ---");
            
           
            System.out.print("Enter recipient cell number: ");
            String recNo = scan.nextLine();

            if (!log.checkCellPhoneNumber(recNo)) {
                System.out.println("Invalid recipient number format!");
                continue; 
            }

           
            System.out.print("Enter message: ");
            String messageText = scan.nextLine();

            if (!checkMessageLength(messageText)) {
                System.out.println("Please enter a message of less than 250 characters.");
            } else {
                
                System.out.println("\nChoose an option:");
                System.out.println("1) Send Message");
                System.out.println("2) Disregard Message");
                System.out.println("3) Store Message to send later");
                System.out.print("Enter choice (1-3): ");
                
                int choice = scan.nextInt();
                scan.nextLine(); 

                switch (choice) {
                    case 1 -> {
                        totalMessagesSent++;
                        String messageID = generateMessageID();
                        String messageHash = generateMessageHash(messageID, totalMessagesSent, messageText);
                        System.out.println("Message successfully sent");
                        System.out.println("Message ID: " + messageID);
                        System.out.println("Message Hash: " + messageHash);
                        System.out.println("Recipient: " + recNo);
                        System.out.println("Message: " + messageText);
                    }
                    case 2 -> System.out.println("Press 0 to delete the message");
                    case 3 -> System.out.println("Message successfully stored");
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
        
       
       
        System.out.println("Total messages processed/sent: " + totalMessagesSent);
        
    }
}
