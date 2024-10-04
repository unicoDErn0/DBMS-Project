package dev.praneeth.backend.Prescription;

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
@RequestMapping(path = "/api/v1/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping
    public List<Prescription> getPrescriptions() {
        return prescriptionService.getPrescriptions();
    }

    @PostMapping
    public void addPrescription(@RequestBody Prescription prescription) {
        prescriptionService.addPrescription(prescription);
    }

    @DeleteMapping(path = "/{prescriptionId}")
    public void deletePrescription(@PathVariable("prescriptionId") Integer prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
    }

    @PutMapping(path = "/{prescriptionId}")
    public void updatePrescription(@PathVariable("prescriptionId") Integer prescriptionId, @RequestBody PrescriptionUpdateRequest updateRequest) {
        prescriptionService.updatePrescription(prescriptionId, updateRequest);
    }
}
