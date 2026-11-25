package chatapplication;

import java.util.ArrayList;

public class Array {
    
    static ArrayList<String> sentMessage = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> messageHash = new ArrayList<>();
    static ArrayList<String> messageID = new ArrayList<>();
    static int index = 0;

    static void sentMessages(String mess) {
        if (index <= sentMessage.size()) {
            sentMessage.add(index, mess);
        } else {
            sentMessage.add(mess);
        }
    }

    static void disregardedMessages(String mess) {
        disregardedMessages.add(mess);
        sentMessage.remove(mess);
        if (index > 0) {
            index--;
        }
    }

    static void allStoredMessages() {
        storedMessages.clear();
        for (int i = 0; i < sentMessage.size(); i++) {
            storedMessages.add(sentMessage.get(i));
        }
    }

    static void longStoredMessages() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages to show");
            return;
        }

        int maxLength = 0;
        int longestIndex = 0;

        for (int i = 0; i < storedMessages.size(); i++) {
            String msg = storedMessages.get(i);
            int currentLength = msg.length();

            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestIndex = i;
            }
        }
        System.out.println("Longest message is: " + storedMessages.get(longestIndex));
    }

    static void messageHash(String hash) {
        messageHash.add(hash);
    }

    static void messageID(String id) {
        if (index <= messageID.size()) {
            messageID.add(index, id);
        } else {
            messageID.add(id);
        }
    }

    static void increm() {
        index++;
    }

    static String getByID(String id) {
        if (messageID.contains(id)) {
            int targetIndex = messageID.indexOf(id);
            return sentMessage.get(targetIndex);
        }
        return "Message not found";
    }
}
