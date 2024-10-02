package dev.praneeth.backend.prescription;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    // Constructor-based dependency injection
    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    // Get all prescriptions
    public List<Prescription> getPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Add a new prescription
    public void addPrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    // Delete a prescription by ID
    public void deletePrescription(Integer prescriptionID) {
        boolean exists = prescriptionRepository.existsById(prescriptionID);
        if (!exists) {
            throw new IllegalStateException("Prescription with ID " + prescriptionID + " does not exist");
        }
        prescriptionRepository.deleteById(prescriptionID);
    }

    // Update an existing prescription
    @Transactional
    public void updatePrescription(Integer prescriptionID, PrescriptionUpdateRequest updateRequest) {
        Prescription prescription = prescriptionRepository.findById(prescriptionID)
                .orElseThrow(() -> new IllegalStateException("Prescription with ID " + prescriptionID + " does not exist"));

        // Update fields if valid
        if (updateRequest.getPrescriptionDate() != null) {
            prescription.setPrescriptionDate(updateRequest.getPrescriptionDate());
        }
        if (updateRequest.getDosage() != null && !updateRequest.getDosage().isEmpty()) {
            prescription.setDosage(updateRequest.getDosage());
        }
        if (updateRequest.getFrequency() != null && !updateRequest.getFrequency().isEmpty()) {
            prescription.setFrequency(updateRequest.getFrequency());
        }
        if (updateRequest.getDuration() != null && updateRequest.getDuration() > 0) {
            prescription.setDuration(updateRequest.getDuration());
        }
        if (updateRequest.getInstructions() != null && !updateRequest.getInstructions().isEmpty()) {
            prescription.setInstructions(updateRequest.getInstructions());
        }

        prescriptionRepository.save(prescription);
    }
}
