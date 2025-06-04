// Class to represent a flight booking
public class Booking {
    private int bookingId;
    private Passenger passenger;
    private Flight flight;
    private int seatNumber;
    private String status; // e.g., "Confirmed", "Cancelled"

    // Constructor
    public Booking(int bookingId, Passenger passenger, Flight flight, int seatNumber, String status) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }

    // Display booking details
    public void displayInfo() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.getName() + " (ID: " + passenger.getId() + ")");
        System.out.println("Flight: " + flight.getFlightNumber() + " from " + flight.getOrigin() + " to " + flight.getDestination());
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Status: " + status);
    }
}