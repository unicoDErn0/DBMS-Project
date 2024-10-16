package dev.praneeth.backend.doctor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDao {

    private final JdbcTemplate jdbcTemplate;

    public DoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add a new doctor
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, specialty, phone_number, email, office_number) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialty(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getOfficeNumber());
    }

    // Get a doctor by ID
    public Doctor getDoctorById(Integer doctorId) {
        String sql = "SELECT * FROM doctors WHERE doctorID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{doctorId}, (rs, rowNum) -> 
            new Doctor(
                rs.getInt("doctorID"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("specialty"),
                rs.getString("phone_number"),
                rs.getString("email"),
                rs.getString("office_number")
            )
        );
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        String sql = "SELECT * FROM doctors";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new Doctor(
                rs.getInt("doctorID"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("specialty"),
                rs.getString("phone_number"),
                rs.getString("email"),
                rs.getString("office_number")
            )
        );
    }

    // Update a doctor
    public void updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET first_name = ?, last_name = ?, specialty = ?, phone_number = ?, email = ?, office_number = ? WHERE doctorID = ?";
        jdbcTemplate.update(sql, doctor.getFirstName(), doctor.getLastName(), doctor.getSpecialty(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getOfficeNumber(), doctor.getDoctorID());
    }

    // Delete a doctor by ID
    public void deleteDoctor(Integer doctorId) {
        String sql = "DELETE FROM doctors WHERE doctorID = ?";
        jdbcTemplate.update(sql, doctorId);
    }

    // Check if email already exists
    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM doctors WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{email}, Integer.class);
        return count != null && count > 0;
    }
}
