package dev.praneeth.backend.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/api/v1/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping
    public List<Billing> getBillings() {
        return billingService.getBillings();
    }

    @PostMapping
    public void addBilling(@RequestBody Billing billing) {
        billingService.addBilling(billing);
    }

    @DeleteMapping(path = "/{billingId}")
    public void deleteBilling(@PathVariable("billingId") Integer billingId) {
        billingService.deleteBilling(billingId);
    }

    @PutMapping(path = "/{billingId}")
    public void updateBilling(@PathVariable("billingId") Integer billingId, @RequestBody BillingUpdateRequest updateRequest) {
        billingService.updateBilling(billingId, updateRequest);
    }
}
