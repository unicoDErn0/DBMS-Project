package dev.praneeth.backend.hospitalization;

import java.time.LocalDate;

public class HospitalizationUpdateRequest {

    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String reason;
    private String notes;
    private Integer patientID;

    // Constructors
    public HospitalizationUpdateRequest() {}

    public HospitalizationUpdateRequest(LocalDate admissionDate, LocalDate dischargeDate, String reason, String notes, Integer patientID) {
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.notes = notes;
        this.patientID = patientID;
    }

    // Getters and Setters
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
}
