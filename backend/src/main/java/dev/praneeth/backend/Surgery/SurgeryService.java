package dev.praneeth.backend.surgery;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class SurgeryService {

    private final SurgeryRepository surgeryRepository;

    // Constructor-based dependency injection
    public SurgeryService(SurgeryRepository surgeryRepository) {
        this.surgeryRepository = surgeryRepository;
    }

    // Get all surgeries
    public List<Surgery> getSurgeries() {
        return surgeryRepository.findAll();
    }

    // Add a new surgery
    public void addSurgery(Surgery surgery) {
        surgeryRepository.save(surgery);
    }

    // Delete a surgery by ID
    public void deleteSurgery(Integer surgeryID) {
        boolean exists = surgeryRepository.existsById(surgeryID);
        if (!exists) {
            throw new IllegalStateException("Surgery with ID " + surgeryID + " does not exist");
        }
        surgeryRepository.deleteById(surgeryID);
    }

    // Update an existing surgery
    @Transactional
    public void updateSurgery(Integer surgeryID, SurgeryUpdateRequest updateRequest) {
        Surgery surgery = surgeryRepository.findById(surgeryID)
                .orElseThrow(() -> new IllegalStateException("Surgery with ID " + surgeryID + " does not exist"));

        // Update fields if valid
        if (updateRequest.getSurgeryDate() != null) {
            surgery.setSurgeryDate(updateRequest.getSurgeryDate());
        }
        if (updateRequest.getSurgeryType() != null && !updateRequest.getSurgeryType().isEmpty()) {
            surgery.setSurgeryType(updateRequest.getSurgeryType());
        }
        if (updateRequest.getOutcome() != null && !updateRequest.getOutcome().isEmpty()) {
            surgery.setOutcome(updateRequest.getOutcome());
        }
        if (updateRequest.getPrescriptionID() != null && updateRequest.getPrescriptionID() > 0) {
            surgery.setPrescriptionID(updateRequest.getPrescriptionID());
        }
        if (updateRequest.getDoctorID() != null && updateRequest.getDoctorID() > 0) {
            surgery.setDoctorID(updateRequest.getDoctorID());
        }
        if (updateRequest.getPatientID() != null && updateRequest.getPatientID() > 0) {
            surgery.setPatientID(updateRequest.getPatientID());
        }
        if (updateRequest.getNotes() != null && !updateRequest.getNotes().isEmpty()) {
            surgery.setNotes(updateRequest.getNotes());
        }

        surgeryRepository.save(surgery);
    }
}