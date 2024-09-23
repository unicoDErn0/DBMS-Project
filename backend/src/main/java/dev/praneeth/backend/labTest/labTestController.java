package dev.praneeth.backend.user;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/labTests")
public class LabTestController {

    private final LabTestService labTestService;

    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @GetMapping
    public List<LabTest> getLabTests() {
        return labTestService.getLabTests();
    }

    @PostMapping
    public void addLabTest(@RequestBody LabTest labTest) {
        labTestService.addLabTest(labTest);
    }

    @DeleteMapping(path = "/{labTestId}")
    public void deleteLabTest(@PathVariable("labTestId") Integer labTestId) {
        labTestService.deleteLabTest(labTestId);
    }

    @PutMapping(path = "/{labTestId}")
    public void updateLabTest(@PathVariable("labTestId") Integer labTestId, @RequestBody LabTestUpdateRequest updateRequest) {
        labTestService.updateLabTest(labTestId, updateRequest);
    }
}
