package fit;

import java.io.*;
import java.util.*;

public class ClientInteraction {

    // Method to send a message to a client
    public static String sendMessage(String instructor, String client, String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\messages.txt", true))) {
            writer.write("Client:" + client + ",Message:From " + instructor + ": " + message);
            writer.newLine();
            return "Message sent to " + client;
        } catch (IOException e) {
            return "Error writing message: " + e.getMessage();
        }
    }

    // Method to view messages from a client
    public static List<String> viewMessages(String client) {
        List<String> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\messages.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Client:" + client)) {
                    messages.add(line.split(",Message:")[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading messages file: " + e.getMessage());
        }
        return messages;
    }

    // Method to provide feedback to a client
    public static String provideFeedback(String client, String feedback) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\feedback.txt", true))) {
            writer.write("Client:" + client + ",Feedback:" + feedback);
            writer.newLine();
            return "Feedback sent to " + client;
        } catch (IOException e) {
            return "Error writing feedback: " + e.getMessage();
        }
    }

    // Method to view client feedback
    public static String viewFeedback(String client) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\feedback.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Client:" + client)) {
                    return line.split(",Feedback:")[1];
                }
            }
        } catch (IOException e) {
            return "Error reading feedback file: " + e.getMessage();
        }
        return "No feedback available";
    }

    // Method to update client progress
    public static String updateProgress(String client, String progressDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\progress.txt", true))) {
            writer.write("Client:" + client + ",Progress:" + progressDetails);
            writer.newLine();
            return "Progress updated for " + client;
        } catch (IOException e) {
            return "Error writing progress: " + e.getMessage();
        }
    }

    // Method to view client progress
    public static String viewProgress(String client) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\progress.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Client:" + client)) {
                    return line.split(",Progress:")[1];
                }
            }
        } catch (IOException e) {
            return "Error reading progress file: " + e.getMessage();
        }
        return "No progress details available";
    }
}