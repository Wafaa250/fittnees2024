package fit;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.util.List;

public class NotificationsandUpdatesSteps {

    private String result;
    private List<String> notifications;

    @When("I send a notification to {string} with message {string}")
    public void iSendANotificationToWithMessage(String recipient, String message) {
        result = fit.NotificationsAndUpdates.sendNotification(recipient, message);
    }

    @Then("the notification should be sent to {string} with message {string}")
    public void theNotificationShouldBeSentToWithMessage(String recipient, String expectedMessage) {
        notifications = fit.NotificationsAndUpdates.viewNotifications(recipient);
        assertTrue("Notification received by recipient", notifications.contains(expectedMessage));
    }

    @When("I view notifications for {string}")
    public void iViewNotificationsFor(String recipient) {
        notifications = fit.NotificationsAndUpdates.viewNotifications(recipient);
    }

    @Then("I should see the notification {string}")
    public void iShouldSeeTheNotification(String expectedMessage) {
        assertTrue("Expected notification found", notifications.contains(expectedMessage));
    }

    @Then("I should see no notifications for {string}")
    public void iShouldSeeNoNotificationsFor(String recipient) {
        notifications = fit.NotificationsAndUpdates.viewNotifications(recipient);
        assertTrue("No notifications for recipient", notifications.isEmpty());
    }

    @When("a new program {string} is added")
    public void aNewProgramIsAdded(String programName) {
        // إنشاء إشعار البرنامج الجديد
        String notificationMessage = "New program available: " + programName;

        // إرسال الإشعار إلى العميل
        result = fit.NotificationsAndUpdates.sendNotification("Hiba", notificationMessage);

        // طباعة الإشعار للتأكد
        System.out.println("New program added and notification sent: " + programName);
    }

   /* @Then("I should receive a notification {string}")
    public void iShouldReceiveANotification(String expectedNotification) {
        notifications = fit.NotificationsAndUpdates.viewNotifications("Hiba");
        System.out.println("Expected: " + expectedNotification);
        System.out.println("Actual: " + notifications);
        assertTrue("Notification received: " + expectedNotification, notifications.contains(expectedNotification.trim()));
    }*/
    @Then("I should receive a notification {string}")
    public void iShouldReceiveANotification(String expectedNotification) {
        // التأكد من أن الإشعارات يتم جلبها بناءً على السيناريو الحالي
        String currentRecipient = expectedNotification.startsWith("New program available") || expectedNotification.startsWith("Program updated") || expectedNotification.startsWith("Program canceled") 
            ? "Hiba" 
            : "Rasmiya";

        // استرجاع الإشعارات
        notifications = fit.NotificationsAndUpdates.viewNotifications(currentRecipient);

        // الطباعة للتأكد
        System.out.println("Expected: " + expectedNotification);
        System.out.println("Actual: " + notifications);

        // التحقق
        if (notifications == null) {
            fail("Notifications list is null for recipient: " + currentRecipient);
        }

        assertTrue("Notification received: " + expectedNotification, notifications.contains(expectedNotification.trim()));
    }






  /*  @When("a client {string} enrolls in the program {string}")
    public void aClientEnrollsInTheProgram(String clientName, String programName) {
        // إنشاء إشعار تسجيل العميل
        String notificationMessage = "Client " + clientName + " enrolled in " + programName;

        // إرسال الإشعار إلى المدرب
        result = fit.NotificationsAndUpdates.sendNotification("Rasmiya", notificationMessage);

        // طباعة الإشعار للتأكد
        System.out.println("Enrollment notification sent: " + notificationMessage);
    }*/
    
    @When("a client {string} enrolls in the program {string}")
    public void aClientEnrollsInTheProgram(String clientName, String programName) {
        String notificationMessage = "Client " + clientName + " enrolled in " + programName;
        result = fit.NotificationsAndUpdates.sendNotification("Rasmiya", notificationMessage);
        System.out.println("Enrollment notification sent: " + notificationMessage);
    }


    @When("the program {string} is updated")
    public void theProgramIsUpdated(String programName) {
        // إنشاء إشعار تحديث البرنامج
        String notificationMessage = "Program updated: " + programName;

        // إرسال الإشعار إلى العميل
        result = fit.NotificationsAndUpdates.sendNotification("Hiba", notificationMessage);

        // طباعة الإشعار للتأكد
        System.out.println("Program updated notification sent: " + programName);
    }

    @When("the client {string} sends a message {string}")
    public void theClientSendsAMessage(String clientName, String messageContent) {
        // إنشاء إشعار إرسال رسالة من العميل
        String notificationMessage = "New message from " + clientName + ": " + messageContent;

        // إرسال الإشعار إلى المدرب
        result = fit.NotificationsAndUpdates.sendNotification("Rasmiya", notificationMessage);

        // طباعة الإشعار للتأكد
        System.out.println("Message notification sent: " + notificationMessage);
    }

    @When("the program {string} is canceled")
    public void theProgramIsCanceled(String programName) {
        // إنشاء إشعار إلغاء البرنامج
        String notificationMessage = "Program canceled: " + programName;

        // إرسال الإشعار إلى العميل
        result = fit.NotificationsAndUpdates.sendNotification("Hiba", notificationMessage);

        // طباعة الإشعار للتأكد
        System.out.println("Cancellation notification sent: " + programName);
    }
}
