import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MentalHealth extends User {
    private List<MentalHealthEntry> entries;  // List to store entries for mental health data

    // Constructor initializes username, password, full name, date of birth, and an empty list of entries
    public MentalHealth(String username, String password, String fullName, LocalDate dateOfBirth) {
        super(username, password, fullName, dateOfBirth);
        this.entries = new ArrayList<>();
    }

    // Adds a new mental health entry to the list with mood, stress, cognitive well-being, and sleep quality
    public void addEntry(int moodRate, int stressLevel, String cognitiveWellbeing, int sleepQuality) {
        entries.add(new MentalHealthEntry(moodRate, stressLevel, cognitiveWellbeing, sleepQuality));
    }

    // Displays the latest mental health entry, if available
    @Override
    public void displayHealth() {
        if (entries.isEmpty()) {
            System.out.println("No mental health data available.");
            return;
        }

        MentalHealthEntry latestEntry = entries.get(entries.size() - 1);
        System.out.println("Latest Mental Health Information:");
        latestEntry.display();
    }

    // Displays all mental health history, showing each entry in reverse order (most recent first)
    public void displayHistory() {
        if (entries.isEmpty()) {
            System.out.println("No mental health history available.");
            return;
        }

        System.out.println("Mental Health History:");
        // Loop through entries in reverse order and display them
        for (int i = entries.size() - 1; i >= 0; i--) {
            System.out.println("\nEntry " + (entries.size() - i) + ":");
            entries.get(i).display();
        }
    }

    // Inner class to represent a single mental health entry with date, mood, stress, cognitive well-being, and sleep quality
    private class MentalHealthEntry {
        private LocalDate date;  // Date of the entry
        private int moodRate;  // Mood rating on a scale of 1-10
        private int stressLevel;  // Stress level on a scale of 1-10
        private String cognitiveWellbeing;  // Cognitive well-being status (good/average/poor)
        private int sleepQuality;  // Sleep quality rating on a scale of 1-10

        // Constructor initializes the entry with values and sets the date to today
        public MentalHealthEntry(int moodRate, int stressLevel, String cognitiveWellbeing, int sleepQuality) {
            this.date = LocalDate.now();
            this.moodRate = moodRate;
            this.stressLevel = stressLevel;
            this.cognitiveWellbeing = cognitiveWellbeing;
            this.sleepQuality = sleepQuality;
        }

        // Displays the details of a single mental health entry including GWA score and feedback
        public void display() {
            System.out.println("Date: " + date);
            System.out.println("Mood Rate: " + moodRate + "/10");
            System.out.println("Stress Level: " + stressLevel + "/10");
            System.out.println("Cognitive Well-being: " + cognitiveWellbeing);
            System.out.println("Sleep Quality: " + sleepQuality + "/10");

            double gwa = calculateGWA();  // Calculate General Well-being Assessment (GWA)
            System.out.println("General Well-being Assessment (GWA): " + String.format("%.2f", gwa) + "/10");

            // Provide feedback based on GWA score
            if (gwa < 5) {
                System.out.println("Your GWA is low. This might indicate that you're experiencing some challenges with your mental well-being.");
                System.out.println("Consider speaking with a mental health professional or trying some self-care activities to improve your overall well-being.");
            } else if (gwa < 7) {
                System.out.println("Your GWA is moderate. There might be room for improvement in some areas of your mental well-being.");
                System.out.println("Consider focusing on self-care and stress management techniques to enhance your overall mental health.");
            } else {
                System.out.println("Your GWA is good. Keep up the positive habits that contribute to your mental well-being!");
            }
        }

        // Calculates the General Well-being Assessment (GWA) score based on mood, stress, cognitive well-being, and sleep quality
        private double calculateGWA() {
            double cognitiveScore;
            // Assign cognitive score based on the cognitive well-being input
            switch (cognitiveWellbeing.toLowerCase()) {
                case "good":
                    cognitiveScore = 10;
                    break;
                case "average":
                    cognitiveScore = 5;
                    break;
                case "poor":
                    cognitiveScore = 1;
                    break;
                default:
                    cognitiveScore = 0;
            }

            // Calculate GWA based on mood, stress level, cognitive score, and sleep quality
            return (moodRate + (10 - stressLevel) + cognitiveScore + sleepQuality) / 4.0;
        }
    }
}
