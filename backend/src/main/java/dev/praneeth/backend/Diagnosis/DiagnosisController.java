package dev.praneeth.backend.Diagnosis;

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
@RequestMapping(path = "/api/v1/diagnosis")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping
    public List<Diagnosis> getDiagnoses() {
        return diagnosisService.getDiagnoses();
    }

    @PostMapping
    public void addDiagnosis(@RequestBody Diagnosis diagnosis) {
        diagnosisService.addDiagnosis(diagnosis);
    }

    @DeleteMapping(path = "/{diagnosisId}")
    public void deleteDiagnosis(@PathVariable("diagnosisId") Integer diagnosisId) {
        diagnosisService.deleteDiagnosis(diagnosisId);
    }

    @PutMapping(path = "/{diagnosisId}")
    public void updateDiagnosis(@PathVariable("diagnosisId") Integer diagnosisId, @RequestBody DiagnosisUpdateRequest updateRequest) {
        diagnosisService.updateDiagnosis(diagnosisId, updateRequest);
    }
}