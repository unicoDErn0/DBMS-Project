package dev.praneeth.backend.nurse;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository
            extends JpaRepository<Nurse, Integer> {

    @Query("SELECT n FROM Nurse n WHERE n.email = ?1")
    Optional<Nurse> findByEmail(String email);

    @Query("SELECT n FROM Nurse n WHERE n.shift = ?1")
    Optional<Nurse> findByShift(Nurse.Shift shift);
}
