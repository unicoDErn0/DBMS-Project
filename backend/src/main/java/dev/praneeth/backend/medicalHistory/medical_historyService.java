package dev.praneeth.backend.medicalhistory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {

    private final MedicalHistoryDao medicalHistoryDaos;

    public MedicalHistoryService(MedicalHistoryDao medicalHistoryDao) {
        this.medicalHistoryDao = medicalHistoryDao;
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistoryDao.getAllMedicalHistories();
    }

    public void addMedicalHistory(MedicalHistory medicalHistory) {
        medicalHistoryDao.addMedicalHistory(medicalHistory);
    }

    public void deleteMedicalHistory(Integer historyId) {
        MedicalHistory existingHistory = medicalHistoryDao.getMedicalHistoryById(historyId);
        if (existingHistory == null) {
            throw new IllegalStateException("Medical history with id " + historyId + " does not exist");
        }
        medicalHistoryDao.deleteMedicalHistory(historyId);
    }

    public List<MedicalHistory> getHistoriesByPatient(Integer patientId) {
        return medicalHistoryDao.getHistoriesByPatientId(patientId);
    }

    public List<MedicalHistory> getHistoriesByDoctor(Integer doctorId) {
        return medicalHistoryDao.getHistoriesByDoctorId(doctorId);
    }
}
