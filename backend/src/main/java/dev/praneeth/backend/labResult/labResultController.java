package dev.praneeth.backend.user;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/labResults")
public class LabResultController {

    private final LabResultService labResultService;

    public LabResultController(LabResultService labResultService) {
        this.labResultService = labResultService;
    }

    @GetMapping
    public List<LabResult> getLabResults() {
        return labResultService.getLabResults();
    }

    @PostMapping
    public void addLabResult(@RequestBody LabResult labResult) {
        labResultService.addLabResult(labResult);
    }

    @DeleteMapping(path = "/{labResultId}")
    public void deleteLabResult(@PathVariable("labResultId") Integer labResultId) {
        labResultService.deleteLabResult(labResultId);
    }

    @PutMapping(path = "/{labResultId}")
    public void updateLabResult(@PathVariable("labResultId") Integer labResultId, @RequestBody LabResultUpdateRequest updateRequest) {
        labResultService.updateLabResult(labResultId, updateRequest);
    }
}
