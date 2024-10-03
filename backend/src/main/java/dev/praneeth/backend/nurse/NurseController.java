package dev.praneeth.backend.nurse;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/nurses")
public class NurseController {

    private final NurseService NurseService;

    public NurseController(NurseService nurseService) {
        this.NurseService = nurseService;
    }

    @GetMapping
    public List<Nurse> GetNurses() {
        return NurseService.GetNurses();
    }

    @PostMapping
    public void AddNurse(@RequestBody Nurse nurse) {
        NurseService.AddNurse(nurse);
    }

    @DeleteMapping(path = "/{nurseId}")
    public void DeleteNurse(@PathVariable("nurseId") Integer nurseId) {
        NurseService.DeleteNurse(nurseId);
    }

    @PutMapping(path = "/{nurseId}")
    public void UpdateNurse(@PathVariable("nurseId") Integer nurseId, @RequestBody NurseUpdateRequest updateRequest) {
        NurseService.UpdateNurse(nurseId, updateRequest);
    }
}
