package dev.praneeth.backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {

    @Query("SELECT s FROM Surgery s WHERE s.doctorID = ?1")
    Optional<Surgery> findByDoctorID(Integer doctorID);

    @Query("SELECT s FROM Surgery s WHERE s.surgeryID = ?1")
    Optional<Surgery> findBySurgeryID(Integer surgeryID);
}