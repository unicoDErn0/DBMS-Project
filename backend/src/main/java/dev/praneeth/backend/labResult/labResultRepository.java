package dev.praneeth.backend.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LabResultRepository extends JpaRepository<LabResult, Integer> {

    @Query("SELECT l FROM LabResult l WHERE l.labResultID = ?1")
    Optional<LabResult> findById(Integer labResultID);
}
