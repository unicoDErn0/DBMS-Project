package dev.praneeth.backend.srvs;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SrvsRepository extends JpaRepository<Srvs, Integer> {

    @Query("SELECT s FROM Srvs s WHERE s.srvsType = ?1")
    Optional<Srvs> findBySrvsType(Srvs.SrvsType srvsType);
}
