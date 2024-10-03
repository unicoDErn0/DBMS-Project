package dev.praneeth.backend.srvs;

public class SrvsUpdateRequest {

    private Srvs.SrvsType srvsType;
    private Integer billingID;

    // Constructors
    public SrvsUpdateRequest() {}

    public SrvsUpdateRequest(Srvs.SrvsType srvsType, Integer billingID) {
        this.srvsType = srvsType;
        this.billingID = billingID;
    }

    // Getters and Setters
    public Srvs.SrvsType getSrvsType() {
        return srvsType;
    }

    public void setSrvsType(Srvs.SrvsType srvsType) {
        this.srvsType = srvsType;
    }

    public Integer getBillingID() {
        return billingID;
    }

    public void setBillingID(Integer billingID) {
        this.billingID = billingID;
    }
}
