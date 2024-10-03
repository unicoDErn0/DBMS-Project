package dev.praneeth.backend.appointment;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService; // Corrected the capitalization
    }

    @GetMapping
    public List<Appointment> getAppointments() {
        return appointmentService.getAppointments(); // Correct capitalization
    }

    @PostMapping
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment); // Correct capitalization
    }

    @DeleteMapping(path = "/{appointmentId}")
    public void deleteAppointment(@PathVariable("appointmentId") Integer appointmentId) {
        appointmentService.deleteAppointment(appointmentId); // Correct capitalization
    }

    @PutMapping(path = "/{appointmentId}")
    public void updateAppointment(@PathVariable("appointmentId") Integer appointmentId, @RequestBody AppointmentUpdateRequest updateRequest) {
        appointmentService.updateAppointment(appointmentId, updateRequest); // Assuming updateAppointment method exists
    }
}
