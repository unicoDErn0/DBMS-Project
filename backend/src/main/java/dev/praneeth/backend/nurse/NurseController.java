package dev.praneeth.backend.nurse;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/nurses")
public class NurseController {

    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    @GetMapping
    public List<Nurse> getNurses() {
        return nurseService.getNurses();
    }

    @PostMapping
    public void addNurse(@RequestBody Nurse nurse) {
        nurseService.addNurse(nurse);
    }

    @DeleteMapping(path = "/{nurseId}")
    public void deleteNurse(@PathVariable("nurseId") Integer nurseId) {
        nurseService.deleteNurse(nurseId);
    }

    @PutMapping(path = "/{nurseId}")
    public void updateNurse(@PathVariable("nurseId") Integer nurseId, @RequestBody NurseUpdateRequest updateRequest) {
        nurseService.updateNurse(nurseId, updateRequest);
    }
}
