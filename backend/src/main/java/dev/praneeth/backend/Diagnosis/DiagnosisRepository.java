package dev.praneeth.backend.Diagnosis;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {

    @Query("SELECT d FROM Diagnosis d WHERE d.prescriptionID = ?1")
    Optional<Diagnosis> findByPrescriptionID(Integer prescriptionID);

    @Query("SELECT d FROM Diagnosis d WHERE d.labTestID = ?1")
    Optional<Diagnosis> findByLabTestID(Integer labTestID);
    
    @Query("SELECT d FROM Diagnosis d WHERE d.labResultID = ?1")
    Optional<Diagnosis> findByLabResultID(Integer labResultID);

    @Query("SELECT d FROM Diagnosis d WHERE d.diagnosisID = ?1")
    Optional<Diagnosis> findByDiagnosisID(Integer diagnosisID);
}
