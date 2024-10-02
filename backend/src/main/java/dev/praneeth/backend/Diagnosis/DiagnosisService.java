package dev.praneeth.backend.user;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    // Constructor-based dependency injection
    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    // Get all diagnosis records
    public List<Diagnosis> getDiagnoses() {
        return diagnosisRepository.findAll();
    }

    // Add a new diagnosis record
    public void addDiagnosis(Diagnosis diagnosis) {
        // You can implement any additional validation logic here if required
        diagnosisRepository.save(diagnosis);
    }

    // Delete a diagnosis record by ID
    public void deleteDiagnosis(Integer diagnosisId) {
        boolean exists = diagnosisRepository.existsById(diagnosisId);
        if (!exists) {
            throw new IllegalStateException("Diagnosis with id " + diagnosisId + " does not exist");
        }
        diagnosisRepository.deleteById(diagnosisId);
    }

    // Update an existing diagnosis record
    @Transactional
    public void updateDiagnosis(Integer diagnosisId, DiagnosisUpdateRequest updateRequest) {
        // Retrieve the diagnosis record or throw an exception if not found
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId)
                .orElseThrow(() -> new IllegalStateException("Diagnosis with id " + diagnosisId + " does not exist"));

        // Update prescriptionID if it's valid
        if (updateRequest.getPrescriptionID() != null) {
            diagnosis.setPrescriptionID(updateRequest.getPrescriptionID());
        }

        // Update labTestID if it's valid
        if (updateRequest.getLabTestID() != null) {
            diagnosis.setLabTestID(updateRequest.getLabTestID());
        }

        // Update labResultID if it's valid
        if (updateRequest.getLabResultID() != null) {
            diagnosis.setLabResultID(updateRequest.getLabResultID());
        }

        // Update notes if it's valid
        if (updateRequest.getNotes() != null) {
            diagnosis.setNotes(updateRequest.getNotes());
        }

        // Save the updated diagnosis entity
        diagnosisRepository.save(diagnosis);
    }
}
