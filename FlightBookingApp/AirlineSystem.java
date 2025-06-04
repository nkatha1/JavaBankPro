import java.util.ArrayList;
import java.util.List;

// Class to manage flights, passengers, and bookings
public class AirlineSystem {
    private List<Flight> flights;
    private List<Passenger> passengers;
    private List<Booking> bookings;

    // Constructor
    public AirlineSystem() {
        flights = new ArrayList<>();
        passengers = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // Add a new flight
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Add a new passenger
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Add a new booking
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Find flight by flight number
    public Flight findFlightByNumber(String flightNumber) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return f;
            }
        }
        return null;
    }

    // Find passenger by ID
    public Passenger findPassengerById(int id) {
        for (Passenger p : passengers) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Show all available flights
    public void displayAllFlights() {
        for (Flight f : flights) {
            f.displayInfo();
            System.out.println("-------------");
        }
    }

    // Show all passengers
    public void displayAllPassengers() {
        for (Passenger p : passengers) {
            p.displayInfo();
            System.out.println("-------------");
        }
    }

    // Show all bookings
    public void displayAllBookings() {
        for (Booking b : bookings) {
            b.displayInfo();
            System.out.println("-------------");
        }
    }
}