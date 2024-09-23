package dev.praneeth.backend.user;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "labResult")
public class labResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labResultID;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    @Column(name = "result_value", length = 50)
    private String resultValue;

    @Column(name = "notes", length = 500)
    private String notes;

    // Constructors
    public labResult() {}

    public labResult(LocalDate testDate, String resultValue, String notes) {
        this.testDate = testDate;
        this.resultValue = resultValue;
        this.notes = notes;
    }

    // Getters and Setters
    public Integer getLabResultID() {
        return labResultID;
    }

    public void setLabResultID(Integer labResultID) {
        this.labResultID = labResultID;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "labResult{" +
                "labResultID=" + labResultID +
                ", testDate=" + testDate +
                ", resultValue='" + resultValue + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}

