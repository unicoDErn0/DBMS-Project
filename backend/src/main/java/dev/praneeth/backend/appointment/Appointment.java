package dev.praneeth.backend.appointment;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentID;

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "diagnosis_id")
    private Integer diagnosisID;

    @Column(name = "doctor_id", nullable = false)
    private Integer doctorID;

    @Column(name = "patient_id", nullable = false)
    private Integer patientID;

    public enum Status {
        Scheduled,
        Completed,
        Cancelled
    }

    // Constructors
    public Appointment() {}

    public Appointment(LocalDate appointmentDate, LocalTime appointmentTime, Status status, Integer diagnosisID, Integer doctorID, Integer patientID) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.diagnosisID = diagnosisID;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    // Getters and Setters
    public Integer getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getDiagnosisID() {
        return diagnosisID;
    }

    public void setDiagnosisID(Integer diagnosisID) {
        this.diagnosisID = diagnosisID;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }
}
