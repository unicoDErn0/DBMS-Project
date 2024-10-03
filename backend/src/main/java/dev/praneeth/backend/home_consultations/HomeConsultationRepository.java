package dev.praneeth.backend.home_consultations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeConsultationRepository extends JpaRepository<HomeConsultation, Integer> {
    // Additional custom queries can be defined here if needed
}
