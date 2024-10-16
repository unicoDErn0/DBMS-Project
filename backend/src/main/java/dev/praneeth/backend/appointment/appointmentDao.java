package dev.praneeth.backend.appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentDao {
    private final String jdbcURL = "jdbc:your_database_url"; // Update with your DB URL
    private final String jdbcUsername = "your_db_username"; // Update with your DB username
    private final String jdbcPassword = "your_db_password"; // Update with your DB password

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (appointment_date, appointment_time, status, diagnosis_id, doctor_id, patient_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(appointment.getAppointmentDate()));
            statement.setTime(2, Time.valueOf(appointment.getAppointmentTime()));
            statement.setString(3, appointment.getStatus().name());
            statement.setObject(4, appointment.getDiagnosisID() != null ? appointment.getDiagnosisID() : null);
            statement.setInt(5, appointment.getDoctorID());
            statement.setInt(6, appointment.getPatientID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Appointment> findById(Integer appointmentID) {
        String sql = "SELECT * FROM appointments WHERE appointmentID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointmentID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(mapResultSetToAppointment(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                appointments.add(mapResultSetToAppointment(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET appointment_date = ?, appointment_time = ?, status = ?, diagnosis_id = ?, doctor_id = ?, patient_id = ? WHERE appointmentID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(appointment.getAppointmentDate()));
            statement.setTime(2, Time.valueOf(appointment.getAppointmentTime()));
            statement.setString(3, appointment.getStatus().name());
            statement.setObject(4, appointment.getDiagnosisID() != null ? appointment.getDiagnosisID() : null);
            statement.setInt(5, appointment.getDoctorID());
            statement.setInt(6, appointment.getPatientID());
            statement.setInt(7, appointment.getAppointmentID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(Integer appointmentID) {
        String sql = "DELETE FROM appointments WHERE appointmentID = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, appointmentID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Adjusted method names to match those in AppointmentService
    public List<Appointment> getAppointmentsByDoctor(Integer doctorId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctor_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, doctorId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                appointments.add(mapResultSetToAppointment(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsByPatient(Integer patientId) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patient_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patientId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                appointments.add(mapResultSetToAppointment(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    private Appointment mapResultSetToAppointment(ResultSet resultSet) throws SQLException {
        Appointment appointment = new Appointment();
        appointment.setAppointmentID(resultSet.getInt("appointmentID"));
        appointment.setAppointmentDate(resultSet.getDate("appointment_date").toLocalDate());
        appointment.setAppointmentTime(resultSet.getTime("appointment_time").toLocalTime());
        appointment.setStatus(Appointment.Status.valueOf(resultSet.getString("status")));
        appointment.setDiagnosisID(resultSet.getInt("diagnosis_id"));
        appointment.setDoctorID(resultSet.getInt("doctor_id"));
        appointment.setPatientID(resultSet.getInt("patient_id"));
        return appointment;
    }
}
