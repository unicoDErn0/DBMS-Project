package dev.praneeth.backend.Medicine;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/api/v1/medicine")
public class MedicineController {

    private final MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<Medicine> getMedicines() {
        return medicineService.getMedicines();
    }

    @PostMapping
    public void addMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
    }

    @DeleteMapping(path = "/{medicineId}")
    public void deleteMedicine(@PathVariable("medicineId") Integer medicineId) {
        medicineService.deleteMedicine(medicineId);
    }

    @PutMapping(path = "/{medicineId}")
    public void updateMedicine(@PathVariable("medicineId") Integer medicineId, @RequestBody MedicineUpdateRequest updateRequest) {
        medicineService.updateMedicine(medicineId, updateRequest);
    }
}
