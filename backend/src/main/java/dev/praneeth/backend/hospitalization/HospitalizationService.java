package dev.praneeth.backend.hospitalization;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalizationService {

    private final HospitalizationRepository hospitalizationRepository;

    @Autowired
    public HospitalizationService(HospitalizationRepository hospitalizationRepository) {
        this.hospitalizationRepository = hospitalizationRepository;
    }

    // Get all hospitalizations
    public List<Hospitalization> GetHospitalizations() {
        return hospitalizationRepository.findAll();
    }

    // Add a new hospitalization
    public void AddHospitalization(Hospitalization hospitalization) {
        hospitalizationRepository.save(hospitalization);
    }

    // Delete a hospitalization by ID
    public void DeleteHospitalization(Integer hospitalizationID) {
        boolean exists = hospitalizationRepository.existsById(hospitalizationID);
        if (!exists) {
            throw new IllegalStateException("Hospitalization with ID " + hospitalizationID + " does not exist.");
        }
        hospitalizationRepository.deleteById(hospitalizationID);
    }

    // Update a hospitalization by ID
    public void UpdateHospitalization(Integer hospitalizationID, HospitalizationUpdateRequest updateRequest) {
        Hospitalization hospitalization = hospitalizationRepository.findById(hospitalizationID)
                .orElseThrow(() -> new IllegalStateException("Hospitalization with ID " + hospitalizationID + " does not exist."));

        if (updateRequest.getAdmissionDate() != null) {
            hospitalization.setAdmissionDate(updateRequest.getAdmissionDate());
        }
        if (updateRequest.getDischargeDate() != null) {
            hospitalization.setDischargeDate(updateRequest.getDischargeDate());
        }
        if (updateRequest.getReason() != null) {
            hospitalization.setReason(updateRequest.getReason());
        }
        if (updateRequest.getNotes() != null) {
            hospitalization.setNotes(updateRequest.getNotes());
        }
        if (updateRequest.getPatientID() != null) {
            hospitalization.setPatientID(updateRequest.getPatientID());
        }

        hospitalizationRepository.save(hospitalization);
    }
}
