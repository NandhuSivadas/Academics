import java.util.*;

// Attendee class
class Attendee {
    private String name;
    private String email;
    private int registrationId;

    // Constructor
    public Attendee(String name, String email, int registrationId) {
        this.name = name;
        this.email = email;
        this.registrationId = registrationId;
    }

    // Getter for registrationId
    public int getRegistrationId() {
        return registrationId;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name + ", Email: " + email + ", Registration ID: " + registrationId);
    }

    // Override equals and hashCode to ensure uniqueness based on registrationId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attendee)) return false;
        Attendee that = (Attendee) o;
        return this.registrationId == that.registrationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId);
    }
}

// Main class
public class AttendeeSystem {
    private HashSet<Attendee> attendeeSet = new HashSet<>();
    private Scanner sc = new Scanner(System.in);

    // Method to add attendee
    public void addAttendee() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Registration ID: ");
        int regId = sc.nextInt();
        sc.nextLine(); // consume newline

        Attendee attendee = new Attendee(name, email, regId);

        if (attendeeSet.contains(attendee)) {
            System.out.println("Attendee with this registration ID already exists.");
        } else {
            attendeeSet.add(attendee);
            System.out.println("Attendee registered successfully.");
        }
    }

    // Method to display all attendees
    public void displayAttendees() {
        if (attendeeSet.isEmpty()) {
            System.out.println("No attendees registered.");
        } else {
            System.out.println("Registered Attendees:");
            for (Attendee a : attendeeSet) {
                a.display();
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        AttendeeSystem system = new AttendeeSystem();
        int choice;

        do {
            System.out.println("\n--- Attendee System Menu ---");
            System.out.println("1. Add Attendee");
            System.out.println("2. Display All Attendees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = system.sc.nextInt();
            system.sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    system.addAttendee();
                    break;
                case 2:
                    system.displayAttendees();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }
}