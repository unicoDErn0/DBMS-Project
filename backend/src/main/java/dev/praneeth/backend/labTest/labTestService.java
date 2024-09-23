package dev.praneeth.backend.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LabTestService {

    private final LabTestRepository labTestRepository;

    public LabTestService(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    public List<LabTest> getLabTests() {
        return labTestRepository.findAll();
    }

    public void addLabTest(LabTest labTest) {
        labTestRepository.save(labTest);
    }

    public void deleteLabTest(Integer labTestId) {
        boolean exists = labTestRepository.existsById(labTestId);
        if (!exists) {
            throw new IllegalStateException("Lab test with id " + labTestId + " does not exist");
        }
        labTestRepository.deleteById(labTestId);
    }

    @Transactional
    public void updateLabTest(Integer labTestId, LabTestUpdateRequest updateRequest) {
        LabTest labTest = labTestRepository.findById(labTestId)
                .orElseThrow(() -> new IllegalStateException("Lab test with id " + labTestId + " does not exist"));

        if (updateRequest.getNameOfTest() != null && !updateRequest.getNameOfTest().trim().isEmpty()) {
            labTest.setNameOfTest(updateRequest.getNameOfTest());
        }

        if (updateRequest.getDescription() != null) {
            labTest.setDescription(updateRequest.getDescription());
        }

        if (updateRequest.getNormalRange() != null && !updateRequest.getNormalRange().trim().isEmpty()) {
            labTest.setNormalRange(updateRequest.getNormalRange());
        }

        if (updateRequest.getUnits() != null && !updateRequest.getUnits().trim().isEmpty()) {
            labTest.setUnits(updateRequest.getUnits());
        }

        labTestRepository.save(labTest);
    }
}
