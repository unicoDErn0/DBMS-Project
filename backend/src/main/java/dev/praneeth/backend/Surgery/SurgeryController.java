package dev.praneeth.backend.user;

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
@RequestMapping(path = "/api/v1/surgery")
public class SurgeryController {

    private final SurgeryService surgeryService;

    public SurgeryController(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }

    @GetMapping
    public List<Surgery> getSurgeries() {
        return surgeryService.getSurgeries();
    }

    @PostMapping
    public void addSurgery(@RequestBody Surgery surgery) {
        surgeryService.addSurgery(surgery);
    }

    @DeleteMapping(path = "/{surgeryId}")
    public void deleteSurgery(@PathVariable("surgeryId") Integer surgeryId) {
        surgeryService.deleteSurgery(surgeryId);
    }

    @PutMapping(path = "/{surgeryId}")
    public void updateSurgery(@PathVariable("surgeryId") Integer surgeryId, @RequestBody SurgeryUpdateRequest updateRequest) {
        surgeryService.updateSurgery(surgeryId, updateRequest);
    }
}
