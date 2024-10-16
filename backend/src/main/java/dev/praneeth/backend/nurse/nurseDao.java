package dev.praneeth.backend.nurse;

import java.sql.*;
import java.util.Optional;

public class NurseDao {
    private String jdbcURL = "jdbc:your_database_url";
    private String jdbcUsername = "your_db_username";
    private String jdbcPassword = "your_db_password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void addNurse(Nurse nurse) {
        String sql = "INSERT INTO nurses (first_name, last_name, phone_number, email, shift) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nurse.getFirstName());
            statement.setString(2, nurse.getLastName());
            statement.setString(3, nurse.getPhone_number());
            statement.setString(4, nurse.getEmail());
            statement.setString(5, nurse.getShift().name());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Optional<Nurse> findByEmail(String email) {
        String sql = "SELECT * FROM nurses WHERE email = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Nurse nurse = new Nurse();
                nurse.setNurseID(resultSet.getInt("nurseID"));
                nurse.setFirstName(resultSet.getString("first_name"));
                nurse.setLastName(resultSet.getString("last_name"));
                nurse.setPhone_number(resultSet.getString("phone_number"));
                nurse.setEmail(resultSet.getString("email"));
                nurse.setShift(Nurse.Shift.valueOf(resultSet.getString("shift")));
                return Optional.of(nurse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<Nurse> findByShift(Nurse.Shift shift) {
        String sql = "SELECT * FROM nurses WHERE shift = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, shift.name());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Nurse nurse = new Nurse();
                nurse.setNurseID(resultSet.getInt("nurseID"));
                nurse.setFirstName(resultSet.getString("first_name"));
                nurse.setLastName(resultSet.getString("last_name"));
                nurse.setPhone_number(resultSet.getString("phone_number"));
                nurse.setEmail(resultSet.getString("email"));
                nurse.setShift(Nurse.Shift.valueOf(resultSet.getString("shift")));
                return Optional.of(nurse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // Additional methods for other CRUD operations can be added here.
}
