package pl.animaldaycare.ravsky.animaldaycare.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.Owner;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.mapper.OwnerMapper;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.request.OwnerRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.response.OwnerResponse;
import pl.animaldaycare.ravsky.animaldaycare.persistance.OwnerRepository;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;


    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    public Long saveOwner(OwnerRequest ownerRequest) {
        Owner owner = ownerMapper.map(ownerRequest);
        return ownerRepository.save(owner).getId();
    }

    public OwnerResponse getOwner(Long id) {
        var owner = ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));
        return ownerMapper.map(owner);
    }
}
