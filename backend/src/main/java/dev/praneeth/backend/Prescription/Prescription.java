package dev.praneeth.backend.user;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prescriptionID;

    @Column(name = "prescription_date", nullable = false)
    private LocalDate prescriptionDate;

    @Column(name = "dosage", nullable = false, length = 50)
    private String dosage;

    @Column(name = "frequency", nullable = false, length = 50)
    private String frequency;

    @Column(name = "duration", nullable = false)
    private Integer duration; // Duration in days

    @Column(name = "instructions", nullable = true, length = 255)
    private String instructions;

    // Constructors
    public Prescription() {}

    public Prescription(LocalDate prescriptionDate, String dosage, String frequency, Integer duration, String instructions) {
        this.prescriptionDate = prescriptionDate;
        this.dosage = dosage;
        this.frequency = frequency;
        this.duration = duration;
        this.instructions = instructions;
    }

    // Getters and Setters
    public Integer getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(Integer prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID=" + prescriptionID +
                ", prescriptionDate=" + prescriptionDate +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", duration=" + duration +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}