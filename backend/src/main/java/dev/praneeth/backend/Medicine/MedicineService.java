package dev.praneeth.backend.medicine;

import java.util.List;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    // Constructor-based dependency injection
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // Get all medicines
    public List<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    // Add a new medicine
    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    // Delete a medicine by ID
    public void deleteMedicine(Integer medicineID) {
        boolean exists = medicineRepository.existsById(medicineID);
        if (!exists) {
            throw new IllegalStateException("Medicine with ID " + medicineID + " does not exist");
        }
        medicineRepository.deleteById(medicineID);
    }

    // Update an existing medicine
    @Transactional
    public void updateMedicine(Integer medicineID, MedicineUpdateRequest updateRequest) {
        Medicine medicine = medicineRepository.findById(medicineID)
                .orElseThrow(() -> new IllegalStateException("Medicine with ID " + medicineID + " does not exist"));

        // Update fields if valid
        if (updateRequest.getName() != null && !updateRequest.getName().isEmpty()) {
            medicine.setName(updateRequest.getName());
        }
        if (updateRequest.getDescription() != null && !updateRequest.getDescription().isEmpty()) {
            medicine.setDescription(updateRequest.getDescription());
        }
        if (updateRequest.getDosageForm() != null && !updateRequest.getDosageForm().isEmpty()) {
            medicine.setDosageForm(updateRequest.getDosageForm());
        }
        if (updateRequest.getStrength() != null && !updateRequest.getStrength().isEmpty()) {
            medicine.setStrength(updateRequest.getStrength());
        }

        medicineRepository.save(medicine);
    }
}
