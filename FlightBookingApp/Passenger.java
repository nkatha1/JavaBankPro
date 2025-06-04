// Class to represent a passenger
public class Passenger {
    private int id;
    private String name;
    private String passportNumber;

    // Constructor
    public Passenger(int id, String name, String passportNumber) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    // Display passenger info
    public void displayInfo() {
        System.out.println("Passenger ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Passport Number: " + passportNumber);
    }
}