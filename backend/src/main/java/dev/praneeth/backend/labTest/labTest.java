package dev.praneeth.backend.labTest;

public class LabTest {

    private Integer labTestID;
    private String nameOfTest;
    private String description;
    private String normalRange;
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

    @Override
    public String toString() {
        return "LabTest{" +
                "labTestID=" + labTestID +
                ", nameOfTest='" + nameOfTest + '\'' +
                ", description='" + description + '\'' +
                ", normalRange='" + normalRange + '\'' +
                ", units='" + units + '\'' +
                '}';
    }
}
