package dev.praneeth.backend.home_consultations;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "home_consultations")
public class HomeConsultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultationID;

    @Column(name = "consultation_date", nullable = false)
    private LocalDate consultationDate;

    @Column(name = "consultation_time", nullable = false)
    private LocalTime consultationTime;

    @Column(name = "outcome", length = 255)
    private String outcome;

    @Column(name = "doctor_id", nullable = false)
    private Integer doctorID;

    @Column(name = "patient_id", nullable = false)
    private Integer patientID;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    // Constructors
    public HomeConsultation() {}

    public HomeConsultation(LocalDate consultationDate, LocalTime consultationTime, String outcome, Integer doctorID, Integer patientID, String notes) {
        this.consultationDate = consultationDate;
        this.consultationTime = consultationTime;
        this.outcome = outcome;
        this.doctorID = doctorID;
        this.patientID = patientID;
        this.notes = notes;
    }

    // Getters and Setters
    public Integer getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(Integer consultationID) {
        this.consultationID = consultationID;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public LocalTime getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(LocalTime consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "HomeConsultation{" +
                "consultationID=" + consultationID +
                ", consultationDate=" + consultationDate +
                ", consultationTime=" + consultationTime +
                ", outcome='" + outcome + '\'' +
                ", doctorID=" + doctorID +
                ", patientID=" + patientID +
                ", notes='" + notes + '\'' +
                '}';
    }
}
