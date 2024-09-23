package dev.praneeth.backend.user;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LabResultService {

    private final LabResultRepository labResultRepository;

    public LabResultService(LabResultRepository labResultRepository) {
        this.labResultRepository = labResultRepository;
    }

    public List<LabResult> getLabResults() {
        return labResultRepository.findAll();
    }

    public void addLabResult(LabResult labResult) {
        labResultRepository.save(labResult);
    }

    public void deleteLabResult(Integer labResultId) {
        boolean exists = labResultRepository.existsById(labResultId);
        if (!exists) {
            throw new IllegalStateException("Lab result with id " + labResultId + " does not exist");
        }
        labResultRepository.deleteById(labResultId);
    }

    @Transactional
    public void updateLabResult(Integer labResultId, LabResultUpdateRequest updateRequest) {
        // Retrieve the lab result or throw an exception if not found
        LabResult labResult = labResultRepository.findById(labResultId)
                .orElseThrow(() -> new IllegalStateException("Lab result with id " + labResultId + " does not exist"));

        // Update testDate if it's valid
        if (updateRequest.getTestDate() != null) {
            try {
                LocalDate parsedTestDate = LocalDate.parse(updateRequest.getTestDate()); // Convert testDate from String to LocalDate
                labResult.setTestDate(parsedTestDate);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for testDate: " + updateRequest.getTestDate());
            }
        }

        // Update resultValue if it's valid
        if (updateRequest.getResultValue() != null && !updateRequest.getResultValue().trim().isEmpty()) {
            labResult.setResultValue(updateRequest.getResultValue());
        }

        // Update notes if it's valid
        if (updateRequest.getNotes() != null && !updateRequest.getNotes().trim().isEmpty()) {
            labResult.setNotes(updateRequest.getNotes());
        }

        // Save the updated lab result entity
        labResultRepository.save(labResult);
    }
}
