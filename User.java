import java.time.LocalDate;  // To handle date-related operations.

public abstract class User {
    private String username;
    private String password;
    private LocalDate registrationDate;
    private String fullName;
    private LocalDate dateOfBirth;

    // Constructor: Initializes a User object with provided username, password, full name, and date of birth.
    // Sets the registration date to the current date.
    public User(String username, String password, String fullName, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.registrationDate = LocalDate.now();  // Sets registrationDate to the current date.
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getter for the username.
    public String getUsername() {
        return username;
    }

    // Setter for the username, allowing modification of the username.
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for the password.
    public String getPassword() {
        return password;
    }

    // Setter for the password, allowing modification of the password.
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for the registration date.
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    // Getter for the full name of the user.
    public String getFullName() {
        return fullName;
    }

    // Setter for the full name, allowing modification of the user's full name.
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter for the user's date of birth.
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // Setter for the user's date of birth, allowing modification of the birthdate.
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Calculates and returns the user's age based on the current date and the user's date of birth.
    public int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();  // Subtracts birth year from the current year to estimate age.
    }

    // Abstract method that must be implemented by subclasses to display health-related information.
    // The specific implementation of this method will be defined in the subclasses.
    public abstract void displayHealth();
}
