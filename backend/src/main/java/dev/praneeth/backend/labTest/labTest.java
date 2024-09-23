package dev.praneeth.backend.user;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_tests")
public class LabTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labTestID;

    @Column(name = "name_of_test", nullable = false, length = 100)
    private String nameOfTest;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "normal_range", length = 50)
    private String normalRange;

    @Column(name = "units", length = 20)
    private String units;

    // Constructors
    public LabTest() {}

    public LabTest(String nameOfTest, String description, String normalRange, String units) {
        this.nameOfTest = nameOfTest;
        this.description = description;
        this.normalRange = normalRange;
        this.units = units;
    }

    // Getters and Setters
    public Integer getLabTestID() {
        return labTestID;
    }

    public void setLabTestID(Integer labTestID) {
        this.labTestID = labTestID;
    }

    public String getNameOfTest() {
        return nameOfTest;
    }

    public void setNameOfTest(String nameOfTest) {
        this.nameOfTest = nameOfTest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
