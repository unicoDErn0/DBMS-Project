package dev.praneeth.backend.nurse;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class NurseService {

    private final NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public List<Nurse> GetNurses() {
        return nurseRepository.findAll();
    }

    public void AddNurse(Nurse nurse) {
        Optional<Nurse> nurseOptional = nurseRepository.findByEmail(nurse.getEmail());
        if (nurseOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        nurseRepository.save(nurse);
    }

    public void DeleteNurse(Integer nurseId) {
        boolean exists = nurseRepository.existsById(nurseId);
        if (!exists) {
            throw new IllegalStateException("Nurse with id " + nurseId + " does not exist");
        }
        nurseRepository.deleteById(nurseId);
    }

    @Transactional
    public void UpdateNurse(Integer nurseId, NurseUpdateRequest updateRequest) {
        Nurse nurse = nurseRepository.findById(nurseId)
                .orElseThrow(() -> new IllegalStateException("Nurse with id " + nurseId + " does not exist"));

        if (updateRequest.getFirstName() != null && !updateRequest.getFirstName().trim().isEmpty()) {
            nurse.setFirstName(updateRequest.getFirstName());
        }

        if (updateRequest.getLastName() != null && !updateRequest.getLastName().trim().isEmpty()) {
            nurse.setLastName(updateRequest.getLastName());
        }

        if (updateRequest.getEmail() != null && !updateRequest.getEmail().trim().isEmpty()) {
            Optional<Nurse> nurseWithEmail = nurseRepository.findByEmail(updateRequest.getEmail());
            if (nurseWithEmail.isPresent() && !nurseWithEmail.get().getNurseID().equals(nurseId)) {
                throw new IllegalStateException("Email already taken");
            }
            nurse.setEmail(updateRequest.getEmail());
        }

        nurseRepository.save(nurse);
    }
}
