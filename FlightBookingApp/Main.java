import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Main class with user interface and effects
public class Main {

    // ANSI escape codes for colors (works on most terminals)
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        AirlineSystem airline = new AirlineSystem();

        int choice;

        // Welcome splash screen
        printSplash();

        do {
            printMenu();
            System.out.print(CYAN + "Enter your choice: " + RESET);
            while (!scanner.hasNextInt()) {
                System.out.print(RED + "Invalid input. Please enter a number: " + RESET);
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addFlight(scanner, airline);
                    break;
                case 2:
                    addPassenger(scanner, airline);
                    break;
                case 3:
                    bookFlight(scanner, airline);
                    break;
                case 4:
                    System.out.println(YELLOW + "\nAll Flights:\n" + RESET);
                    airline.displayAllFlights();
                    break;
                case 5:
                    System.out.println(YELLOW + "\nAll Passengers:\n" + RESET);
                    airline.displayAllPassengers();
                    break;
                case 6:
                    System.out.println(YELLOW + "\nAll Bookings:\n" + RESET);
                    airline.displayAllBookings();
                    break;
                case 0:
                    System.out.println(GREEN + "Thank you for using the Flight Booking App! Goodbye!" + RESET);
                    break;
                default:
                    System.out.println(RED + "Invalid choice. Try again." + RESET);
            }

            if (choice != 0) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
                clearScreen();
            }

        } while (choice != 0);

        scanner.close();
    }

    // Splash screen with ASCII art and pause
    private static void printSplash() throws InterruptedException {
        clearScreen();
        System.out.println(GREEN + "===============================");
        System.out.println("     FLIGHT BOOKING SYSTEM     ");
        System.out.println("===============================" + RESET);
        System.out.println("Loading");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print(".");
        }
        System.out.println("\n");
        Thread.sleep(700);
        clearScreen();
    }

    // Menu options
    private static void printMenu() {
        System.out.println(CYAN + "=== Flight Booking Menu ===" + RESET);
        System.out.println("1. Add Flight");
        System.out.println("2. Add Passenger");
        System.out.println("3. Book a Flight");
        System.out.println("4. View All Flights");
        System.out.println("5. View All Passengers");
        System.out.println("6. View All Bookings");
        System.out.println("0. Exit");
    }

    // Add flight option
    private static void addFlight(Scanner scanner, AirlineSystem airline) {
        System.out.println("\nEnter Flight Details:");
        System.out.print("Flight Number: ");
        String flightNumber = scanner.nextLine();

        System.out.print("Origin: ");
        String origin = scanner.nextLine();

        System.out.print("Destination: ");
        String destination = scanner.nextLine();

        System.out.print("Departure Date and Time (yyyy-MM-dd HH:mm): ");
        String dtStr = scanner.nextLine();
        LocalDateTime departureTime;
        try {
            departureTime = LocalDateTime.parse(dtStr.replace(" ", "T"));
        } catch (Exception e) {
            System.out.println(RED + "Invalid date format!" + RESET);
            return;
        }

        System.out.print("Total Seats: ");
        int totalSeats;
        try {
            totalSeats = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid number for seats!" + RESET);
            return;
        }

        Flight flight = new Flight(flightNumber, origin, destination, departureTime, totalSeats);
        airline.addFlight(flight);
        System.out.println(GREEN + "Flight added successfully!" + RESET);
    }

    // Add passenger option
    private static void addPassenger(Scanner scanner, AirlineSystem airline) {
        System.out.println("\nEnter Passenger Details:");

        System.out.print("Passenger ID (integer): ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid passenger ID!" + RESET);
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Passport Number: ");
        String passportNumber = scanner.nextLine();

        Passenger passenger = new Passenger(id, name, passportNumber);
        airline.addPassenger(passenger);
        System.out.println(GREEN + "Passenger added successfully!" + RESET);
    }

    // Book a flight option
    private static void bookFlight(Scanner scanner, AirlineSystem airline) {
        System.out.println("\nEnter Booking Details:");

        System.out.print("Booking ID (integer): ");
        int bookingId;
        try {
            bookingId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid booking ID!" + RESET);
            return;
        }

        System.out.print("Passenger ID: ");
        int passengerId;
        try {
            passengerId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid passenger ID!" + RESET);
            return;
        }
        Passenger passenger = airline.findPassengerById(passengerId);
        if (passenger == null) {
            System.out.println(RED + "Passenger not found!" + RESET);
            return;
        }

        System.out.print("Flight Number: ");
        String flightNumber = scanner.nextLine();
        Flight flight = airline.findFlightByNumber(flightNumber);
        if (flight == null) {
            System.out.println(RED + "Flight not found!" + RESET);
            return;
        }

        if (flight.getAvailableSeats() <= 0) {
            System.out.println(RED + "No seats available on this flight!" + RESET);
            return;
        }

        // Book seat and assign seat number (for simplicity seat = totalSeats - availableSeats + 1)
        int seatNumber = flight.getTotalSeats() - flight.getAvailableSeats() + 1;
        if (flight.bookSeat()) {
            Booking booking = new Booking(bookingId, passenger, flight, seatNumber, "Confirmed");
            airline.addBooking(booking);
            System.out.println(GREEN + "Booking confirmed! Seat number: " + seatNumber + RESET);
        } else {
            System.out.println(RED + "Failed to book seat." + RESET);
        }
    }

    // Clear the console screen (works in most terminals)
    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // If clearing screen fails, just print new lines
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}