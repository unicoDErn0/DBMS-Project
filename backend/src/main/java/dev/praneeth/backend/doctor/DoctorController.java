package dev.praneeth.backend.doctor;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/doctors")
public class DoctorController {

    private final DoctorService DoctorService;

    public DoctorController(DoctorService doctorService) {
        this.DoctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> GetDoctors() {
        return DoctorService.GetDoctors();
    }

    @PostMapping
    public void AddDoctor(@RequestBody Doctor doctor) {
        DoctorService.AddDoctor(doctor);
    }

    @DeleteMapping(path = "/{doctorId}")
    public void DeleteDoctor(@PathVariable("doctorId") Integer doctorId) {
        DoctorService.DeleteDoctor(doctorId);
    }

    @PutMapping(path = "/{doctorId}")
    public void UpdateDoctor(@PathVariable("doctorId") Integer doctorId, @RequestBody DoctorUpdateRequest updateRequest) {
        DoctorService.UpdateDoctor(doctorId, updateRequest);
    }
}
