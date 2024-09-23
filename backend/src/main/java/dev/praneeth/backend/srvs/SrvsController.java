package dev.praneeth.backend.srvs;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/srvs")
public class SrvsController {

    private final SrvsService srvsService;

    public SrvsController(SrvsService srvsService) {
        this.srvsService = srvsService;
    }

    @GetMapping
    public ResponseEntity<List<Srvs>> getAllSrvs() {
        List<Srvs> srvsList = srvsService.getSrvs();
        return new ResponseEntity<>(srvsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addSrvs(@RequestBody Srvs srvs) {
        srvsService.addSrvs(srvs);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{srvsID}")
    public ResponseEntity<Void> deleteSrvs(@PathVariable("srvsID") Integer srvsID) {
        srvsService.deleteSrvs(srvsID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{srvsID}")
    public ResponseEntity<Void> updateSrvs(
            @PathVariable("srvsID") Integer srvsID,
            @RequestBody SrvsUpdateRequest updateRequest) {
        srvsService.updateSrvs(srvsID, updateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
