package dev.praneeth.backend.srvs;

import jakarta.persistence.*;

@Entity
@Table(name = "srvs")
public class Srvs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer srvsID;

    @Enumerated(EnumType.STRING)
    @Column(name = "srvs_type", nullable = false)
    private SrvsType srvsType;

    @Column(name = "billing_id")
    private Integer billingID;

    // Enum for SrvsType
    public enum SrvsType {
        Appointment,
        Surgery,
        HomeConsultation
    }

    // Constructors
    public Srvs() {}

    public Srvs(SrvsType srvsType, Integer billingID) {
        this.srvsType = srvsType;
        this.billingID = billingID;
    }

    // Getters and Setters
    public Integer getSrvsID() {
        return srvsID;
    }

    public void setSrvsID(Integer srvsID) {
        this.srvsID = srvsID;
    }

    public SrvsType getSrvsType() {
        return srvsType;
    }

    public void setSrvsType(SrvsType srvsType) {
        this.srvsType = srvsType;
    }

    public Integer getBillingID() {
        return billingID;
    }

    public void setBillingID(Integer billingID) {
        this.billingID = billingID;
    }

    @Override
    public String toString() {
        return "Srvs{" +
                "srvsID=" + srvsID +
                ", srvsType=" + srvsType +
                ", billingID=" + billingID +
                '}';
    }
}
