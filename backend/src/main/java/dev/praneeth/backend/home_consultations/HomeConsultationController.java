package dev.praneeth.backend.home_consultations;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/homeconsultations")
public class HomeConsultationController {

    private final HomeConsultationService homeConsultationService;

    public HomeConsultationController(HomeConsultationService homeConsultationService) {
        this.homeConsultationService = homeConsultationService;
    }

    // Get all consultations
    @GetMapping
    public List<HomeConsultation> getAllConsultations() {
        return homeConsultationService.getAllConsultations();
    }

    // Get a consultation by ID
    @GetMapping(path = "/{consultationID}")
    public Optional<HomeConsultation> getConsultationById(@PathVariable("consultationID") Integer consultationID) {
        return homeConsultationService.getConsultationById(consultationID);
    }

    // Add a new consultation
    @PostMapping
    public void addConsultation(@RequestBody HomeConsultation consultation) {
        homeConsultationService.addConsultation(consultation);
    }

    // Delete a consultation by ID
    @DeleteMapping(path = "/{consultationID}")
    public void deleteConsultation(@PathVariable("consultationID") Integer consultationID) {
        homeConsultationService.deleteConsultation(consultationID);
    }

    // Update a consultation
    @PutMapping(path = "/{consultationID}")
    public void updateConsultation(@PathVariable("consultationID") Integer consultationID, @RequestBody HomeConsultationUpdateRequest updateRequest) {
        homeConsultationService.updateConsultation(consultationID, updateRequest);
    }
}
