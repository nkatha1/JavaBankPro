// Class to represent a doctor in the hospital system
public class Doctor {
    private int id;
    private String name;
    private String specialization;
    private boolean available;  // True if doctor is available for appointments

    // Constructor to create a new doctor
    public Doctor(int id, String name, String specialization, boolean available) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.available = available;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Method to display doctor details
    public void displayInfo() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
    }
}