package dev.praneeth.backend.labTest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LabTestDao {

    private final JdbcTemplate jdbcTemplate;

    public LabTestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<LabTest> getAllLabTests() {
        String sql = "SELECT * FROM lab_tests";
        return jdbcTemplate.query(sql, labTestRowMapper());
    }

    public Optional<LabTest> getLabTestById(Integer id) {
        String sql = "SELECT * FROM lab_tests WHERE labTestID = ?";
        return jdbcTemplate.query(sql, labTestRowMapper(), id).stream().findFirst();
    }

    public int addLabTest(LabTest labTest) {
        String sql = "INSERT INTO lab_tests (name_of_test, description, normal_range, units) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                labTest.getNameOfTest(),
                labTest.getDescription(),
                labTest.getNormalRange(),
                labTest.getUnits());
    }

    public int deleteLabTest(Integer id) {
        String sql = "DELETE FROM lab_tests WHERE labTestID = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int updateLabTest(LabTest labTest) {
        String sql = "UPDATE lab_tests SET name_of_test = ?, description = ?, normal_range = ?, units = ? WHERE labTestID = ?";
        return jdbcTemplate.update(sql,
                labTest.getNameOfTest(),
                labTest.getDescription(),
                labTest.getNormalRange(),
                labTest.getUnits(),
                labTest.getLabTestID());
    }

    private RowMapper<LabTest> labTestRowMapper() {
        return (rs, rowNum) -> {
            LabTest labTest = new LabTest();
            labTest.setLabTestID(rs.getInt("labTestID"));
            labTest.setNameOfTest(rs.getString("name_of_test"));
            labTest.setDescription(rs.getString("description"));
            labTest.setNormalRange(rs.getString("normal_range"));
            labTest.setUnits(rs.getString("units"));
            return labTest;
        };
    }
}
