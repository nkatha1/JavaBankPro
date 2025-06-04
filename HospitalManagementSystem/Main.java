import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        int choice;

        do {
            System.out.println("=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View All Patients");
            System.out.println("5. View All Doctors");
            System.out.println("6. View All Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add Patient
                    System.out.print("Enter Patient ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String pname = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int page = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String pgender = scanner.nextLine();
                    System.out.print("Enter Medical History: ");
                    String history = scanner.nextLine();
                    Patient newPatient = new Patient(pid, pname, page, pgender, history);
                    hospital.addPatient(newPatient);
                    System.out.println("Patient added.\n");
                    break;

                case 2:
                    // Add Doctor
                    System.out.print("Enter Doctor ID: ");
                    int did = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Is the doctor available? (true/false): ");
                    boolean available = scanner.nextBoolean();
                    Doctor newDoctor = new Doctor(did, dname, specialization, available);
                    hospital.addDoctor(newDoctor);
                    System.out.println("Doctor added.\n");
                    break;

                case 3:
                    // Schedule Appointment
                    System.out.print("Enter Appointment ID: ");
                    int aid = scanner.nextInt();
                    System.out.print("Enter Patient ID: ");
                    int apid = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int adid = scanner.nextInt();
                    scanner.nextLine();
                    Patient patient = hospital.findPatientById(apid);
                    Doctor doctor = hospital.findDoctorById(adid);

                    if (patient == null || doctor == null) {
                        System.out.println("Invalid patient or doctor ID.\n");
                        break;
                    }

                    System.out.print("Enter appointment date and time (yyyy-MM-dd HH:mm): ");
                    String dateTimeStr = scanner.nextLine();
                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr.replace(" ", "T"));

                    Appointment newAppointment = new Appointment(aid, patient, doctor, dateTime, "Scheduled");
                    hospital.addAppointment(newAppointment);
                    System.out.println("Appointment scheduled.\n");
                    break;

                case 4:
                    hospital.displayAllPatients();
                    break;

                case 5:
                    hospital.displayAllDoctors();
                    break;

                case 6:
                    hospital.displayAllAppointments();
                    break;

                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }

        } while (choice != 0);

        scanner.close();
    }
}