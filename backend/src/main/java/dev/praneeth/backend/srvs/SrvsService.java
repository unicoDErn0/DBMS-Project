package dev.praneeth.backend.srvs;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SrvsService {

    private final SrvsRepository srvsRepository;

    public SrvsService(SrvsRepository srvsRepository) {
        this.srvsRepository = srvsRepository;
    }

    // Get all srvs
    public List<Srvs> getSrvs() {
        return srvsRepository.findAll();
    }

    // Add a new srvs
    public void addSrvs(Srvs srvs) {
        srvsRepository.save(srvs);
    }

    // Delete a srvs by ID
    public void deleteSrvs(Integer srvsID) {
        boolean exists = srvsRepository.existsById(srvsID);
        if (!exists) {
            throw new IllegalStateException("Srvs with ID " + srvsID + " does not exist.");
        }
        srvsRepository.deleteById(srvsID);
    }

    // Update a srvs by ID
    public void updateSrvs(Integer srvsID, SrvsUpdateRequest updateRequest) {
        Srvs srvs = srvsRepository.findById(srvsID)
                .orElseThrow(() -> new IllegalStateException("Srvs with ID " + srvsID + " does not exist."));

        if (updateRequest.getSrvsType() != null) {
            srvs.setSrvsType(updateRequest.getSrvsType());
        }
        if (updateRequest.getBillingID() != null) {
            srvs.setBillingID(updateRequest.getBillingID());
        }

        srvsRepository.save(srvs);
    }
}
