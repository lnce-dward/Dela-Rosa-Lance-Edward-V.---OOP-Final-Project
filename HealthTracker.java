import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthTracker {
    private static Map<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Main loop of the program that handles the user menu for registration, login, or exit
        while (true) {
            System.out.println("\nWelcome to Health Tracker");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after input

            switch (choice) {
                case 1:
                    register(); // Calls the register function
                    break;
                case 2:
                    login(); // Calls the login function
                    break;
                case 3:
                    System.out.println("Thank you for using Health Tracker. Goodbye!");
                    System.exit(0); // Exits the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register() {
        // Registers a new user by asking for necessary details
        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine();
            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine();
            LocalDate dateOfBirth = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);

            // Create instances of PhysicalHealth and MentalHealth for the user
            PhysicalHealth physicalHealth = new PhysicalHealth(username, password, fullName, dateOfBirth);
            MentalHealth mentalHealth = new MentalHealth(username, password, fullName, dateOfBirth);

            // Store users' physical and mental health objects
            users.put(username, physicalHealth);
            users.put(username + "_mental", mentalHealth);

            System.out.println("Registration successful!");
        } catch (Exception e) {
            System.out.println("An error occurred during registration. Please try again.");
        }
    }

    private static void login() {
        // Handles the login process
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            showMainMenu(user); // Calls the menu once logged in
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void showMainMenu(User user) {
        // Displays the main menu after the user has logged in
        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Physical Health");
            System.out.println("2. Mental Health");
            System.out.println("3. View Physical Health History");
            System.out.println("4. View Mental Health History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Input physical health data based on user type
                    if (user instanceof PhysicalHealth) {
                        inputPhysicalHealthData((PhysicalHealth) user);
                    } else {
                        inputPhysicalHealthData((PhysicalHealth) users.get(user.getUsername()));
                    }
                    break;
                case 2:
                    // Input mental health data for the user
                    User mentalUser = users.get(user.getUsername() + "_mental");
                    if (mentalUser != null && mentalUser instanceof MentalHealth) {
                        inputMentalHealthData((MentalHealth) mentalUser);
                    } else {
                        System.out.println("Mental health information not available.");
                    }
                    break;
                case 3:
                    // Display physical health history
                    if (user instanceof PhysicalHealth) {
                        ((PhysicalHealth) user).displayHistory();
                    } else {
                        ((PhysicalHealth) users.get(user.getUsername())).displayHistory();
                    }
                    break;
                case 4:
                    // Display mental health history
                    User mentalUserHistory = users.get(user.getUsername() + "_mental");
                    if (mentalUserHistory != null && mentalUserHistory instanceof MentalHealth) {
                        ((MentalHealth) mentalUserHistory).displayHistory();
                    } else {
                        System.out.println("Mental health history not available.");
                    }
                    break;
                case 5:
                    return; // Exits the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void inputPhysicalHealthData(PhysicalHealth physicalHealth) {
        // Inputs and stores physical health data
        try {
            System.out.print("Enter weight (kg): ");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter height (cm): ");
            double height = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter blood pressure (systolic/diastolic, e.g., 120/80): ");
            String bpInput = scanner.nextLine();
            String[] bpParts = bpInput.split("/");
            int systolicBP = Integer.parseInt(bpParts[0]);
            int diastolicBP = Integer.parseInt(bpParts[1]);
            System.out.print("Enter heart rate (bpm): ");
            int heartRate = Integer.parseInt(scanner.nextLine());

            physicalHealth.addEntry(weight, height, systolicBP, diastolicBP, heartRate);
            System.out.println("Physical health data added successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while inputting physical health data. Please try again.");
        }
    }

    private static void inputMentalHealthData(MentalHealth mentalHealth) {
        // Inputs and stores mental health data
        try {
            System.out.print("Enter mood rate (1-10): ");
            int moodRate = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter stress level (1-10): ");
            int stressLevel = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter cognitive well-being (good/average/poor): ");
            String cognitiveWellbeing = scanner.nextLine();
            System.out.print("Enter sleep quality (1-10): ");
            int sleepQuality = Integer.parseInt(scanner.nextLine());

            mentalHealth.addEntry(moodRate, stressLevel, cognitiveWellbeing, sleepQuality);
            System.out.println("Mental health data added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values where required.");
        } catch (Exception e) {
            System.out.println("An error occurred while inputting mental health data. Please try again.");
        }
    }
}
