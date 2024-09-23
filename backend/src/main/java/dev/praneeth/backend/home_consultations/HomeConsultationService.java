package dev.praneeth.backend.home_consultations;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeConsultationService {

    private final HomeConsultationRepository homeConsultationRepository;

    @Autowired
    public HomeConsultationService(HomeConsultationRepository homeConsultationRepository) {
        this.homeConsultationRepository = homeConsultationRepository;
    }

    // Get all consultations
    public List<HomeConsultation> getAllConsultations() {
        return homeConsultationRepository.findAll();
    }

    // Get consultation by ID
    public Optional<HomeConsultation> getConsultationById(Integer consultationID) {
        return homeConsultationRepository.findById(consultationID);
    }

    // Add a new consultation
    public void addConsultation(HomeConsultation consultation) {
        homeConsultationRepository.save(consultation);
    }

    // Delete a consultation by ID
    public void deleteConsultation(Integer consultationID) {
        boolean exists = homeConsultationRepository.existsById(consultationID);
        if (!exists) {
            throw new IllegalStateException("Consultation with ID " + consultationID + " does not exist.");
        }
        homeConsultationRepository.deleteById(consultationID);
    }

    // Update a consultation
    public void updateConsultation(Integer consultationID, HomeConsultationUpdateRequest updateRequest) {
        HomeConsultation consultation = homeConsultationRepository.findById(consultationID)
                .orElseThrow(() -> new IllegalStateException("Consultation with ID " + consultationID + " does not exist."));

        if (updateRequest.getConsultationDate() != null) {
            consultation.setConsultationDate(updateRequest.getConsultationDate());
        }
        if (updateRequest.getConsultationTime() != null) {
            consultation.setConsultationTime(updateRequest.getConsultationTime());
        }
        if (updateRequest.getOutcome() != null) {
            consultation.setOutcome(updateRequest.getOutcome());
        }
        if (updateRequest.getDoctorID() != null) {
            consultation.setDoctorID(updateRequest.getDoctorID());
        }
        if (updateRequest.getPatientID() != null) {
            consultation.setPatientID(updateRequest.getPatientID());
        }
        if (updateRequest.getNotes() != null) {
            consultation.setNotes(updateRequest.getNotes());
        }

        homeConsultationRepository.save(consultation);
    }
}
