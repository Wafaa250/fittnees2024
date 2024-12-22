package fit;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Fitness Management System");

        while (running) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleSignUp(scanner);
                    break;
                case 2:
                    handleLogin(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void handleSignUp(Scanner scanner) {
        SignupSource signupSource = new SignupSource();

        System.out.println("\nSign Up:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter role (Admin, Instructor, Client): ");
        String role = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        String result = signupSource.validateSignUp(username, email, role, password, confirmPassword);
        System.out.println(result);
    }

    private static void handleLogin(Scanner scanner) {
        SiginSource signinSource = new SiginSource();

        System.out.println("\nLogin:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        signinSource.checkLoginValidInFile(username, password);
        if (signinSource.getCheckValid() == 1) {
            System.out.println("Login successful. Welcome " + username + "!");
            String role = signinSource.getWorkRole();
            System.out.println("Your role is: " + role);

            // Redirect based on role
            switch (role.toLowerCase()) {
                case "admin":
                    handleUserManagement(scanner);
                    break;
                case "instructor":
                    handleProgramManagement(scanner);
                    break;
                case "client":
                    handleNotifications(scanner);
                    break;
                default:
                    System.out.println("No specific actions for this role.");
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void handleUserManagement(Scanner scanner) {
        UserManagementSource userManager = new UserManagementSource();

        System.out.println("\nUser Management:");
        System.out.println("1. Add User");
        System.out.println("2. Update User Role");
        System.out.println("3. Disable User");
        System.out.println("4. Approve Instructor");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter city: ");
                String city = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter role: ");
                String role = scanner.nextLine();
                System.out.println(userManager.addUser(username, city, email, password, role));
                break;
            case 2:
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                System.out.print("Enter new role: ");
                String newRole = scanner.nextLine();
                System.out.println(userManager.updateUserRole(email, newRole));
                break;
            case 3:
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                System.out.println(userManager.disableUser(email));
                break;
            case 4:
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                System.out.println(userManager.approveInstructorRegistration(email));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleProgramManagement(Scanner scanner) {
        ProgramManagement programManager = new ProgramManagement();

        System.out.println("\nProgram Management:");
        System.out.println("1. Create Program");
        System.out.println("2. Edit Program");
        System.out.println("3. Delete Program");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter program title: ");
                String title = scanner.nextLine();
                System.out.print("Enter duration: ");
                String duration = scanner.nextLine();
                System.out.print("Enter goals: ");
                String goals = scanner.nextLine();
                System.out.print("Enter price: ");
                String price = scanner.nextLine();
                System.out.println(programManager.createProgram(title, duration, goals, price));
                break;
            case 2:
                System.out.print("Enter program title to edit: ");
                String oldTitle = scanner.nextLine();
                System.out.print("Enter new duration: ");
                duration = scanner.nextLine();
                System.out.print("Enter new price: ");
                price = scanner.nextLine();
                System.out.println(programManager.editProgram(oldTitle, duration, price));
                break;
            case 3:
                System.out.print("Enter program title to delete: ");
                title = scanner.nextLine();
                System.out.println(programManager.deleteProgram(title));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleNotifications(Scanner scanner) {
        NotificationsAndUpdates notificationsManager = new NotificationsAndUpdates();

        System.out.println("\nNotifications:");
        System.out.println("1. Send Notification");
        System.out.println("2. View Notifications");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter recipient: ");
                String recipient = scanner.nextLine();
                System.out.print("Enter message: ");
                String message = scanner.nextLine();
                System.out.println(notificationsManager.sendNotification(recipient, message));
                break;
            case 2:
                System.out.print("Enter recipient: ");
                recipient = scanner.nextLine();
                System.out.println(notificationsManager.viewNotifications(recipient));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void handleSubscriptionManagement(Scanner scanner) {
        SubscriptionManagementSource subscriptionManager = new SubscriptionManagementSource();

        System.out.println("\nSubscription Management:");
        System.out.println("1. Add Subscription Plan");
        System.out.println("2. Modify Subscription Plan");
        System.out.println("3. Delete Subscription Plan");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter plan name: ");
                String name = scanner.nextLine();
                System.out.print("Enter price: ");
                int price = scanner.nextInt();
                System.out.println(subscriptionManager.addSubscriptionPlan(name, price));
                break;
            case 2:
                System.out.print("Enter current plan name: ");
                String oldName = scanner.nextLine();
                System.out.print("Enter new plan name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new price: ");
                price = scanner.nextInt();
                System.out.println(subscriptionManager.modifySubscriptionPlan(oldName, newName, price));
                break;
            case 3:
                System.out.print("Enter plan name to delete: ");
                name = scanner.nextLine();
                System.out.println(subscriptionManager.deleteSubscriptionPlan(name));
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
