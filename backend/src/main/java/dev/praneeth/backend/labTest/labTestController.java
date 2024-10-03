package dev.praneeth.backend.labTest;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/labTests")
public class labTestController {

    private final labTestService labTestService;

    public labTestController(labTestService labTestService) {
        this.labTestService = labTestService;
    }

    @GetMapping
    public List<labTest> getlabTests() {
        return labTestService.getlabTests();
    }

    @PostMapping
    public void addlabTest(@RequestBody labTest labTest) {
        labTestService.addlabTest(labTest);
    }

    @DeleteMapping(path = "/{labTestId}")
    public void deletelabTest(@PathVariable("labTestId") Integer labTestId) {
        labTestService.deletelabTest(labTestId);
    }

    @PutMapping(path = "/{labTestId}")
    public void updatelabTest(@PathVariable("labTestId") Integer labTestId, @RequestBody labTestUpdateRequest updateRequest) {
        labTestService.updatelabTest(labTestId, updateRequest);
    }
}
