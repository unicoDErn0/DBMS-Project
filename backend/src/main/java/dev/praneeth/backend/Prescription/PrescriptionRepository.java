package dev.praneeth.backend.Prescription;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

    @Query("SELECT p FROM Prescription p WHERE p.prescriptionID = ?1")
    Optional<Prescription> findByPrescriptionID(Integer prescriptionID);

    @Query("SELECT p FROM Prescription p WHERE p.prescriptionDate = ?1")
    Optional<Prescription> findByPrescriptionDate(String prescriptionDate);

    @Query("SELECT p FROM Prescription p WHERE p.dosage = ?1")
    Optional<Prescription> findByDosage(String dosage);

    @Query("SELECT p FROM Prescription p WHERE p.frequency = ?1")
    Optional<Prescription> findByFrequency(String frequency);

    @Query("SELECT p FROM Prescription p WHERE p.duration = ?1")
    Optional<Prescription> findByDuration(String duration);
    
    @Query("SELECT p FROM Prescription p WHERE p.instructions = ?1")
    Optional<Prescription> findByInstructions(String instructions);
}
