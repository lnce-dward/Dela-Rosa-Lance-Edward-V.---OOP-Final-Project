import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhysicalHealth extends User {
    private List<PhysicalHealthEntry> entries;

    // Constructor: Initializes the user with their username, password, full name, and date of birth,
    // and initializes the list of physical health entries.
    public PhysicalHealth(String username, String password, String fullName, LocalDate dateOfBirth) {
        super(username, password, fullName, dateOfBirth);
        this.entries = new ArrayList<>();
    }

    // Adds a new physical health entry to the list (includes weight, height, blood pressure, and heart rate).
    public void addEntry(double weight, double height, int systolicBP, int diastolicBP, int heartRate) {
        entries.add(new PhysicalHealthEntry(weight, height, systolicBP, diastolicBP, heartRate));
    }

    // Displays the most recent physical health entry, including details like weight, height, BMI, blood pressure, and heart rate.
    @Override
    public void displayHealth() {
        if (entries.isEmpty()) {
            System.out.println("No physical health data available.");
            return;
        }

        PhysicalHealthEntry latestEntry = entries.get(entries.size() - 1);
        System.out.println("Latest Physical Health Information:");
        latestEntry.display();
    }

    // Displays all physical health history, showing each entry in reverse chronological order.
    public void displayHistory() {
        if (entries.isEmpty()) {
            System.out.println("No physical health history available.");
            return;
        }

        System.out.println("Physical Health History:");
        // Loop through entries in reverse order and display them
        for (int i = entries.size() - 1; i >= 0; i--) {
            System.out.println("\nEntry " + (entries.size() - i) + ":");
            entries.get(i).display();
        }
    }

    // Inner class to represent a single physical health entry with date, weight, height, blood pressure, and heart rate.
    private class PhysicalHealthEntry {
        private LocalDate date;
        private double weight;
        private double height;
        private int systolicBP;
        private int diastolicBP;
        private int heartRate;

        // Constructor: Initializes a physical health entry with weight, height, blood pressure, and heart rate
        // and sets the current date.
        public PhysicalHealthEntry(double weight, double height, int systolicBP, int diastolicBP, int heartRate) {
            this.date = LocalDate.now();
            this.weight = weight;
            this.height = height;
            this.systolicBP = systolicBP;
            this.diastolicBP = diastolicBP;
            this.heartRate = heartRate;
        }

        // Displays the details of a single physical health entry including BMI, blood pressure status, and heart rate status.
        public void display() {
            System.out.println("Date: " + date);
            System.out.println("Weight: " + weight + " kg");
            System.out.println("Height: " + height + " cm");
            System.out.println("BMI: " + String.format("%.2f", calculateBMI()));
            System.out.println("Blood Pressure: " + systolicBP + "/" + diastolicBP + " mmHg");
            System.out.println("Heart Rate: " + heartRate + " bpm");

            // Determine and display weight status based on BMI
            if (calculateBMI() < 18.5) {
                System.out.println("Weight Status: Underweight");
            } else if (calculateBMI() < 25) {
                System.out.println("Weight Status: Normal weight");
            } else if (calculateBMI() < 30) {
                System.out.println("Weight Status: Overweight");
            } else {
                System.out.println("Weight Status: Obese");
            }

            // Determine and display blood pressure status
            if (systolicBP < 90 || diastolicBP < 60) {
                System.out.println("Blood Pressure Status: Low");
            } else if ((systolicBP <= 120 && diastolicBP <= 80)) {
                System.out.println("Blood Pressure Status: Normal");
            } else if (systolicBP <= 130 && diastolicBP <= 80) {
                System.out.println("Blood Pressure Status: Elevated");
            } else {
                System.out.println("Blood Pressure Status: High");
            }

            // Determine and display heart rate status
            if (heartRate < 60) {
                System.out.println("Heart Rate Status: Low");
            } else if (heartRate < 100) {
                System.out.println("Heart Rate Status: Normal");
            } else {
                System.out.println("Heart Rate Status: High");
            }
        }

        // Calculates BMI using the formula: BMI = weight / (height^2), where height is in meters.
        private double calculateBMI() {
            double heightInMeters = height / 100;
            return weight / (heightInMeters * heightInMeters);
        }
    }
}
