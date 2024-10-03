package dev.praneeth.backend.doctor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> GetDoctors() {
        return doctorRepository.findAll();
    }

    public void AddDoctor(Doctor doctor) {
        Optional<Doctor> doctorOptional = doctorRepository.findByEmail(doctor.getEmail());
        if (doctorOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        doctorRepository.save(doctor);
    }

    public void DeleteDoctor(Integer doctorId) {
        boolean exists = doctorRepository.existsById(doctorId);
        if (!exists) {
            throw new IllegalStateException("Doctor with id " + doctorId + " does not exist");
        }
        doctorRepository.deleteById(doctorId);
    }

    @Transactional
    public void UpdateDoctor(Integer doctorId, DoctorUpdateRequest updateRequest) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalStateException("Doctor with id " + doctorId + " does not exist"));

        if (updateRequest.getFirstName() != null && !updateRequest.getFirstName().trim().isEmpty()) {
            doctor.setFirstName(updateRequest.getFirstName());
        }

        if (updateRequest.getLastName() != null && !updateRequest.getLastName().trim().isEmpty()) {
            doctor.setLastName(updateRequest.getLastName());
        }

        if (updateRequest.getSpecialty() != null && !updateRequest.getSpecialty().trim().isEmpty()) {
            doctor.setSpecialty(updateRequest.getSpecialty());
        }

        if (updateRequest.getEmail() != null && !updateRequest.getEmail().trim().isEmpty()) {
            Optional<Doctor> doctorWithEmail = doctorRepository.findByEmail(updateRequest.getEmail());
            if (doctorWithEmail.isPresent() && !doctorWithEmail.get().getDoctorID().equals(doctorId)) {
                throw new IllegalStateException("Email already taken");
            }
            doctor.setEmail(updateRequest.getEmail());
        }

        doctorRepository.save(doctor);
    }
}
