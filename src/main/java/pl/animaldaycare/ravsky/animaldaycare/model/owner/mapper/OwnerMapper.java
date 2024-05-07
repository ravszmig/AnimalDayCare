package pl.animaldaycare.ravsky.animaldaycare.model.owner.mapper;

import org.springframework.stereotype.Component;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.Owner;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.request.OwnerRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.response.OwnerResponse;

@Component
public interface OwnerMapper {
    Owner map(OwnerRequest ownerRequest);
    OwnerResponse map(Owner owner);
}