package dev.praneeth.backend.user;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "surgery")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer surgeryID;

    @Column(name = "surgery_date", nullable = false)
    private LocalDate surgeryDate;

    @Column(name = "surgery_type", nullable = false, length = 100)
    private String surgeryType;

    @Column(name = "outcome", nullable = true, length = 255)
    private String outcome;

    @Column(name = "prescription_ID", nullable = false)
    private Integer prescriptionID;

    @Column(name = "notes", nullable = true, columnDefinition = "TEXT")
    private String notes;

    @Column(name = "doctor_ID", nullable = false)
    private Integer doctorID;

    // Constructors
    public Surgery() {}

    public Surgery(LocalDate surgeryDate, String surgeryType, String outcome, Integer prescriptionID, String notes, Integer doctorID) {
        this.surgeryDate = surgeryDate;
        this.surgeryType = surgeryType;
        this.outcome = outcome;
        this.prescriptionID = prescriptionID;
        this.notes = notes;
        this.doctorID = doctorID;
    }

    // Getters and Setters
    public Integer getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public LocalDate getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(LocalDate surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Integer getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(Integer prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "surgeryID=" + surgeryID +
                ", surgeryDate=" + surgeryDate +
                ", surgeryType='" + surgeryType + '\'' +
                ", outcome='" + outcome + '\'' +
                ", prescriptionID=" + prescriptionID +
                ", notes='" + notes + '\'' +
                ", doctorID=" + doctorID +
                '}';
    }
}
