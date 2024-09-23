package dev.praneeth.backend.user;

import java.time.LocalDate;

public class LabResultUpdateRequest {

    private String testDate;
    private String resultValue;
    private String notes;

    // Getters and setters
    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
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

    // Optional method to get the parsed test date as LocalDate
    public LocalDate getParsedTestDate() {
        return LocalDate.parse(testDate);
    }
}
