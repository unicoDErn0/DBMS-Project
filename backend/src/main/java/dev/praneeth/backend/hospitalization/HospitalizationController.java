package dev.praneeth.backend.hospitalization;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/hospitalizations")
public class HospitalizationController {

    private final HospitalizationService hospitalizationService;

    public HospitalizationController(HospitalizationService hospitalizationService) {
        this.hospitalizationService = hospitalizationService;
    }

    @GetMapping
    public List<Hospitalization> GetHospitalizations() {
        return hospitalizationService.GetHospitalizations();
    }

    @PostMapping
    public void AddHospitalization(@RequestBody Hospitalization hospitalization) {
        hospitalizationService.AddHospitalization(hospitalization);
    }

    @DeleteMapping(path = "/{hospitalizationID}")
    public void DeleteHospitalization(@PathVariable("hospitalizationID") Integer hospitalizationID) {
        hospitalizationService.DeleteHospitalization(hospitalizationID);
    }

    @PutMapping(path = "/{hospitalizationID}")
    public void UpdateHospitalization(@PathVariable("hospitalizationID") Integer hospitalizationID, @RequestBody HospitalizationUpdateRequest updateRequest) {
        hospitalizationService.UpdateHospitalization(hospitalizationID, updateRequest);
    }
}
