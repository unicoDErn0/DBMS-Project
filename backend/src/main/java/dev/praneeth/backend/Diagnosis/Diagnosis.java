package dev.praneeth.backend.Diagnosis;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diagnosisID;

    @Column(name = "prescription_ID", nullable = false)
    private Integer prescriptionID;

    @Column(name = "lab_test_ID", nullable = false)
    private Integer labTestID;

    @Column(name = "lab_result_ID", nullable = false)
    private Integer labResultID;

    @Column(name = "notes", nullable = true, length = 255)
    private String notes;

    // Constructors
    public Diagnosis() {}

    public Diagnosis(Integer prescriptionID, Integer labTestID, Integer labResultID, String notes) {
        this.prescriptionID = prescriptionID;
        this.labTestID = labTestID;
        this.labResultID = labResultID;
        this.notes = notes;
    }

    // Getters and Setters
    public Integer getDiagnosisID() {
        return diagnosisID;
    }

    public void setDiagnosisID(Integer diagnosisID) {
        this.diagnosisID = diagnosisID;
    }

    public Integer getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(Integer prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Integer getLabTestID() {
        return labTestID;
    }

    public void setLabTestID(Integer labTestID) {
        this.labTestID = labTestID;
    }

    public Integer getLabResultID() {
        return labResultID;
    }

    public void setLabResultID(Integer labResultID) {
        this.labResultID = labResultID;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "diagnosisID=" + diagnosisID +
                ", prescriptionID=" + prescriptionID +
                ", labTestID=" + labTestID +
                ", labResultID=" + labResultID +
                ", notes='" + notes + '\'' +
                '}';
    }
}