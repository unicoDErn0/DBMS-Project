package dev.praneeth.backend.appointment;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final AppointmentDao appointmentDao;

    public AppointmentService(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public List<Appointment> getAppointments() {
        return appointmentDao.getAllAppointments();
    }

    public void addAppointment(Appointment appointment) {
        appointmentDao.addAppointment(appointment);
    }

    public void deleteAppointment(Integer appointmentId) {
        Optional<Appointment> appointmentOptional = appointmentDao.findById(appointmentId);
        if (!appointmentOptional.isPresent()) {
            throw new IllegalStateException("Appointment with id " + appointmentId + " does not exist");
        }
        appointmentDao.deleteAppointment(appointmentId);
    }

    public List<Appointment> getAppointmentsByDoctor(Integer doctorId) {
        return appointmentDao.getAppointmentsByDoctor(doctorId);
    }

    public List<Appointment> getAppointmentsByPatient(Integer patientId) {
        return appointmentDao.getAppointmentsByPatient(patientId);
    }
}
