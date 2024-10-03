package dev.praneeth.backend.doctor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository
            extends JpaRepository<Doctor, Integer> {

    @Query("SELECT d FROM Doctor d WHERE d.email = ?1")
    Optional<Doctor> findByEmail(String email);

    @Query("SELECT d FROM Doctor d WHERE d.specialty = ?1")
    Optional<Doctor> findBySpecialty(String specialty);
}
