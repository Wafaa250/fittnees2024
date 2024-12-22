package fit;

import java.io.*;
import java.util.*;

public class NotificationsAndUpdates {

	private static final String NOTIFICATIONS_FILE = "C:\\Users\\Msys\\eclipse-workspace\\fit\\src\\main\\resources\\notifications.txt";

    // Method to send a notification
	/*public static String sendNotification(String recipient, String message) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTIFICATIONS_FILE, true))) {
	        String notification = "Recipient:" + recipient + ",Message:" + message;
	        writer.write(notification);
	        writer.newLine();
	        System.out.println("Notification written: " + notification);
	        return notification;
	    } catch (IOException e) {
	        System.out.println("Error writing to notifications file: " + e.getMessage());
	        return "Error sending notification.";
	    }
	}*/

	public static String sendNotification(String recipient, String message) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTIFICATIONS_FILE, true))) {
	        String notification = "Recipient:" + recipient + ",Message:" + message.trim();
	        writer.write(notification);
	        writer.newLine();
	        System.out.println("Notification written: " + notification);
	        return notification;
	    } catch (IOException e) {
	        System.out.println("Error writing to notifications file: " + e.getMessage());
	        return "Error sending notification.";
	    }
	}



    // Method to view notifications for a recipient
	public static List<String> viewNotifications(String recipient) {
	    List<String> notifications = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(NOTIFICATIONS_FILE))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("Recipient:" + recipient)) {
	                String message = line.split(",Message:")[1].trim();
	                notifications.add(message);
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Error reading notifications file: " + e.getMessage());
	    }
	    return notifications;
	}




  /*  public static void main(String[] args) {
        // Example usage
        System.out.println(sendNotification("Hiba", "New program available: Yoga for Beginners"));
        System.out.println(viewNotifications("Hiba"));

        System.out.println(sendNotification("Rasmiya", "Client Hiba enrolled in Yoga for Beginners"));
        System.out.println(viewNotifications("Rasmiya"));

        System.out.println(sendNotification("Hiba", "Program updated: Yoga for Beginners"));
        System.out.println(viewNotifications("Hiba"));

        System.out.println(sendNotification("Rasmiya", "New message from Hiba: I have a question about my schedule."));
        System.out.println(viewNotifications("Rasmiya"));

        System.out.println(sendNotification("Hiba", "Program canceled: Yoga for Beginners"));
        System.out.println(viewNotifications("Hiba"));
    }*/
}
