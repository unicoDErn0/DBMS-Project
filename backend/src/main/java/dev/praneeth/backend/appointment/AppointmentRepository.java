package dev.praneeth.backend.appointment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository
            extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a WHERE a.doctorID = ?1")
    List<Appointment> findByDoctorId(Integer doctorId);

    @Query("SELECT a FROM Appointment a WHERE a.patientID = ?1")
    List<Appointment> findByPatientId(Integer patientId);

    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate = ?1")
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
}
