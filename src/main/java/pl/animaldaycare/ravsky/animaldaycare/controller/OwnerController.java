package pl.animaldaycare.ravsky.animaldaycare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.request.OwnerRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.response.OwnerResponse;
import pl.animaldaycare.ravsky.animaldaycare.service.OwnerService;

@RestController
@RequestMapping("api/v1/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PutMapping("/new")
    public ResponseEntity<Long> newOwner(@RequestBody OwnerRequest ownerRequest) {
       return new ResponseEntity<>(ownerService.saveOwner(ownerRequest), HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<OwnerResponse> getOwner(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwner(id), HttpStatus.OK);
    }

}
