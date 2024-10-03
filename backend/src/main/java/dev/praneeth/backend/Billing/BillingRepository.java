package dev.praneeth.backend.Billing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

    @Query("SELECT b FROM Billing b WHERE b.serviceID = ?1")
    Optional<Billing> findByServiceID(Integer serviceID);
    // need to make one for billing id too
}
