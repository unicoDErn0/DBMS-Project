package dev.praneeth.backend.user;

import java.math.BigDecimal;
import java.time.LocalDate;
import dev.praneeth.backend.user.Billing.Status;


// gotta check whether all actions are allowed or not
public class BillingUpdateRequest {

    private BigDecimal totalAmount;
    private BigDecimal patientPayableAmount;
    private LocalDate billingDate;
    private Integer serviceID;
    private Status status;

    // Getters and setters
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPatientPayableAmount() {
        return patientPayableAmount;
    }

    public void setPatientPayableAmount(BigDecimal patientPayableAmount) {
        this.patientPayableAmount = patientPayableAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
