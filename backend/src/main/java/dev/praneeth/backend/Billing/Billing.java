package dev.praneeth.backend.user;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billingID;

    @Column(name = "total_amount", nullable = true, precision = 10, scale = 2)
    private Double totalAmount;

    @Column(name = "patient_payable_amount", nullable = true, precision = 10, scale = 2)
    private Double patientPayableAmount;

    @Column(name = "billing_date", nullable = false)
    private LocalDate billingDate;

    // dueDate will be 2 weeks from billingDate
    @Transient
    private LocalDate dueDate;

    @Column(name = "service_ID", nullable = false)
    private Integer serviceID;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    // Enum for payment status
    public enum Status {
        PAID, UNPAID, PENDING
    }

    // Constructors
    public Billing() {}

    public Billing(Double totalAmount, Double patientPayableAmount, LocalDate billingDate, Integer serviceID, Status status) {
        this.totalAmount = totalAmount;
        this.patientPayableAmount = patientPayableAmount;
        this.billingDate = billingDate;
        this.serviceID = serviceID;
        this.status = status;
        this.dueDate = billingDate.plusWeeks(2);  // Set due date to 2 weeks from billing date
    }

    // Getters and Setters
    public Integer getBillingID() {
        return billingID;
    }

    public void setBillingID(Integer billingID) {
        this.billingID = billingID;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPatientPayableAmount() {
        return patientPayableAmount;
    }

    public void setPatientPayableAmount(Double patientPayableAmount) {
        this.patientPayableAmount = patientPayableAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
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

    @Override
    public String toString() {
        return "Billing{" +
                "billingID=" + billingID +
                ", totalAmount=" + totalAmount +
                ", patientPayableAmount=" + patientPayableAmount +
                ", billingDate=" + billingDate +
                ", dueDate=" + dueDate +
                ", serviceID=" + serviceID +
                ", status=" + status +
                '}';
    }
}
