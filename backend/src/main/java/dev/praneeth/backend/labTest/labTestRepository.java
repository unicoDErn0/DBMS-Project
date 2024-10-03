package dev.praneeth.backend.labTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface labTestRepository extends JpaRepository<labTest, Integer> {
    // Custom queries can be added here if needed
}
