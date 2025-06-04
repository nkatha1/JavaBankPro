import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Class to represent an appointment between a patient and a doctor
public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;
    private String status; // e.g., "Scheduled", "Completed", "Cancelled"

    // Constructor to create a new appointment
    public Appointment(int id, Patient patient, Doctor doctor, LocalDateTime appointmentDateTime, String status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = appointmentDateTime;
        this.status = status;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method to display appointment details
    public void displayInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Appointment ID: " + id);
        System.out.println("Patient: " + patient.getName() + " (ID: " + patient.getId() + ")");
        System.out.println("Doctor: " + doctor.getName() + " (ID: " + doctor.getId() + ")");
        System.out.println("Date & Time: " + appointmentDateTime.format(formatter));
        System.out.println("Status: " + status);
    }
}