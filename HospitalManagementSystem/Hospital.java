import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Class to manage the hospital system
public class Hospital {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    // Constructor
    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    // Method to add a new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Method to add a new doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to schedule a new appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Method to find a patient by ID
    public Patient findPatientById(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Method to find a doctor by ID
    public Doctor findDoctorById(int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    // Display all patients
    public void displayAllPatients() {
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("-------------");
        }
    }

    // Display all doctors
    public void displayAllDoctors() {
        for (Doctor d : doctors) {
            d.displayInfo();
            System.out.println("-------------");
        }
    }

    // Display all appointments
    public void displayAllAppointments() {
        for (Appointment a : appointments) {
            a.displayInfo();
            System.out.println("-------------");
        }
    }
}