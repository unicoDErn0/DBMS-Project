package dev.praneeth.backend.labTest;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class labTestService {

    private final labTestRepository labTestRepository;

    public labTestService(labTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    public List<labTest> getlabTests() {
        return labTestRepository.findAll();
    }

    public void addlabTest(labTest labTest) {
        labTestRepository.save(labTest);
    }

    public void deletelabTest(Integer labTestId) {
        boolean exists = labTestRepository.existsById(labTestId);
        if (!exists) {
            throw new IllegalStateException("Lab test with id " + labTestId + " does not exist");
        }
        labTestRepository.deleteById(labTestId);
    }

    @Transactional
    public void updatelabTest(Integer labTestId, labTestUpdateRequest updateRequest) {
        labTest labTest = labTestRepository.findById(labTestId)
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
