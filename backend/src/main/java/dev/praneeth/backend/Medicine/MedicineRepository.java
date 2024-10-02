package dev.praneeth.backend.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

    @Query("SELECT m FROM Medicine m WHERE m.name = ?1")
    Optional<Medicine> findByName(String name);

    @Query("SELECT m FROM Medicine m WHERE m.dosageForm = ?1")
    Optional<Medicine> findByDosageForm(String dosageForm);

    @Query("SELECT m FROM Medicine m WHERE m.strength = ?1")
    Optional<Medicine> findByStrength(String strength);

    @Query("SELECT m FROM Medicine m WHERE m.medicineID = ?1")
    Optional<Medicine> findByMedicineID(Integer medicineID);
}
