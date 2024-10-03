package dev.praneeth.backend.appointment;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private final AppointmentRepository AppointmentRepository;

    public AppointmentService(AppointmentRepository AppointmentRepository) {
        this.AppointmentRepository = AppointmentRepository;
    }

    public List<Appointment> getAppointments() {
        return AppointmentRepository.findAll();
    }

    public void addAppointment(Appointment appointment) {
        AppointmentRepository.save(appointment);
    }

    public void deleteAppointment(Integer appointmentId) {
        boolean exists = AppointmentRepository.existsById(appointmentId);
        if (!exists) {
            throw new IllegalStateException("Appointment with id " + appointmentId + " does not exist");
        }
        AppointmentRepository.deleteById(appointmentId);
    }

    public List<Appointment> getAppointmentsByDoctor(Integer doctorId) {
        return AppointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByPatient(Integer patientId) {
        return AppointmentRepository.findByPatientId(patientId);
    }

    public void updateAppointment(Integer appointmentId, AppointmentUpdateRequest updateRequest) {
        Optional<Appointment> appointmentOptional = AppointmentRepository.findById(appointmentId);
        
        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();

            // Update date and time if provided
            if (updateRequest.getDateTime() != null) {
                appointment.setAppointmentDate(updateRequest.getDateTime().toLocalDate());
                appointment.setAppointmentTime(updateRequest.getDateTime().toLocalTime());
            }

            // Update status if provided
            if (updateRequest.getStatus() != null) {
                appointment.setStatus(Appointment.Status.valueOf(updateRequest.getStatus()));
            }

            AppointmentRepository.save(appointment);
        } else {
            throw new IllegalStateException("Appointment with id " + appointmentId + " does not exist");
        }
    }
}
