package dev.praneeth.backend.hospitalization;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospitalizations")
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalizationID;

    @Column(name = "admission_date", nullable = false)
    private LocalDate admissionDate;

    @Column(name = "discharge_date")
    private LocalDate dischargeDate;

    @Column(name = "reason", length = 255)
    private String reason;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "patient_id", nullable = false)
    private Integer patientID;

    // Constructors
    public Hospitalization() {}

    public Hospitalization(LocalDate admissionDate, LocalDate dischargeDate, String reason, String notes, Integer patientID) {
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.notes = notes;
        this.patientID = patientID;
    }

    // Getters and Setters
    public Integer getHospitalizationID() {
        return hospitalizationID;
    }

    public void setHospitalizationID(Integer hospitalizationID) {
        this.hospitalizationID = hospitalizationID;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "hospitalizationID=" + hospitalizationID +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", reason='" + reason + '\'' +
                ", notes='" + notes + '\'' +
                ", patientID=" + patientID +
                '}';
    }
}
