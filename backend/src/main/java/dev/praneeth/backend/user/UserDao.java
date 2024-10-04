package dev.praneeth.backend.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userRowMapper());
    }

    public Optional<User> getUserById(Integer id) {
        String sql = "SELECT * FROM users WHERE patientID = ?";
        return jdbcTemplate.query(sql, userRowMapper(), id)
                .stream().findFirst();
    }

    public Optional<User> getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.query(sql, userRowMapper(), email)
                .stream().findFirst();
    }

    public int addUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, dob, gender, address, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, 
            user.getFirstName(), 
            user.getLastName(),
            user.getDob(),
            user.getGender().toString(),
            user.getAddress(),
            user.getPhone_number(),
            user.getEmail(),
            user.getPassword()
        );
    }

    public int deleteUser(Integer id) {
        String sql = "DELETE FROM users WHERE patientID = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateUser(User user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, dob = ?, gender = ?, address = ?, phone_number = ?, email = ?, password = ? WHERE patientID = ?";
        return jdbcTemplate.update(sql,
            user.getFirstName(),
            user.getLastName(),
            user.getDob(),
            user.getGender().toString(),
            user.getAddress(),
            user.getPhone_number(),
            user.getEmail(),
            user.getPassword(),
            user.getPatientID()
        );
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setPatientID(rs.getInt("patientID"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setDob(rs.getDate("dob").toLocalDate());
            user.setGender(User.Gender.valueOf(rs.getString("gender")));
            user.setAddress(rs.getString("address"));
            user.setPhone_number(rs.getString("phone_number"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        };
    }
}
