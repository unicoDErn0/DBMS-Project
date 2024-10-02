package dev.praneeth.backend.Billing;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    // Constructor-based dependency injection
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    // Get all billing records
    public List<Billing> getBillings() {
        return billingRepository.findAll();
    }

    // Add a new billing record
    public void addBilling(Billing billing) {
        // You can implement any additional validation logic here if required
        billingRepository.save(billing);
    }

    // Delete a billing record by ID
    public void deleteBilling(Integer billingId) {
        boolean exists = billingRepository.existsById(billingId);
        if (!exists) {
            throw new IllegalStateException("Billing with id " + billingId + " does not exist");
        }
        billingRepository.deleteById(billingId);
    }

    // Update an existing billing record
    @Transactional
public void updateBilling(Integer billingId, BillingUpdateRequest updateRequest) {
    // Retrieve the billing record or throw an exception if not found
    Billing billing = billingRepository.findById(billingId)
            .orElseThrow(() -> new IllegalStateException("Billing with id " + billingId + " does not exist"));

    // Update totalAmount if it's valid
    if (updateRequest.getTotalAmount() != null && updateRequest.getTotalAmount().compareTo(BigDecimal.ZERO) > 0) {
        billing.setTotalAmount(updateRequest.getTotalAmount());
    }

    // Update patientPayableAmount if it's valid
    if (updateRequest.getPatientPayableAmount() != null && updateRequest.getPatientPayableAmount().compareTo(BigDecimal.ZERO) > 0) {
        billing.setPatientPayableAmount(updateRequest.getPatientPayableAmount());
    }

    // Update billingDate if it's valid
    if (updateRequest.getBillingDate() != null) {
        LocalDate billingDate = updateRequest.getBillingDate();
        billing.setBillingDate(billingDate);
    }

    // Update serviceID if it's valid
    if (updateRequest.getServiceID() != null && updateRequest.getServiceID() > 0) {
        billing.setServiceID(updateRequest.getServiceID());
    }

    // Update status if it's valid
    if (updateRequest.getStatus() != null) {
        billing.setStatus(updateRequest.getStatus());
    }

    // Save the updated billing entity
    billingRepository.save(billing);
}

}
