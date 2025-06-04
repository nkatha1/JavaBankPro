import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Class to represent a flight
public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private int totalSeats;
    private int availableSeats;

    // Constructor to initialize a flight
    public Flight(String flightNumber, String origin, String destination, LocalDateTime departureTime, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially all seats are available
    }

    // Getters and Setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Decrease available seats when a booking is made
    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    // Display flight details
    public void displayInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("From: " + origin + " To: " + destination);
        System.out.println("Departure Time: " + departureTime.format(formatter));
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
    }
}