package dev.praneeth.backend.medicalhistory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MedicalHistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public MedicalHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MedicalHistory> getAllMedicalHistories() {
        String sql = "SELECT * FROM medical_histories";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new MedicalHistory(
                rs.getInt("historyID"),
                rs.getObject("record_date", LocalDate.class),
                rs.getString("diagnosis"),
                rs.getString("treatment"),
                rs.getString("notes"),
                rs.getInt("patient_id")
            )
        );
    }

    public void addMedicalHistory(MedicalHistory medicalHistory) {
        String sql = "INSERT INTO medical_histories (record_date, diagnosis, treatment, notes, patient_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, medicalHistory.getRecordDate(), medicalHistory.getDiagnosis(), medicalHistory.getTreatment(), medicalHistory.getNotes(), medicalHistory.getPatientID());
    }

    public MedicalHistory getMedicalHistoryById(Integer historyId) {
        String sql = "SELECT * FROM medical_histories WHERE historyID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{historyId}, (rs, rowNum) -> 
            new MedicalHistory(
                rs.getInt("historyID"),
                rs.getObject("record_date", LocalDate.class),
                rs.getString("diagnosis"),
                rs.getString("treatment"),
                rs.getString("notes"),
                rs.getInt("patient_id")
            )
        );
    }

    public void deleteMedicalHistory(Integer historyId) {
        String sql = "DELETE FROM medical_histories WHERE historyID = ?";
        jdbcTemplate.update(sql, historyId);
    }

    public void updateMedicalHistory(MedicalHistory medicalHistory) {
        String sql = "UPDATE medical_histories SET record_date = ?, diagnosis = ?, treatment = ?, notes = ?, patient_id = ? WHERE historyID = ?";
        jdbcTemplate.update(sql, medicalHistory.getRecordDate(), medicalHistory.getDiagnosis(), medicalHistory.getTreatment(), medicalHistory.getNotes(), medicalHistory.getPatientID(), medicalHistory.getHistoryID());
    }

    public List<MedicalHistory> getHistoriesByPatientId(Integer patientId) {
        String sql = "SELECT * FROM medical_histories WHERE patient_id = ?";
        return jdbcTemplate.query(sql, new Object[]{patientId}, (rs, rowNum) -> 
            new MedicalHistory(
                rs.getInt("historyID"),
                rs.getObject("record_date", LocalDate.class),
                rs.getString("diagnosis"),
                rs.getString("treatment"),
                rs.getString("notes"),
                rs.getInt("patient_id")
            )
        );
    }

    // You can also add a method to get histories by doctor ID if needed
}
