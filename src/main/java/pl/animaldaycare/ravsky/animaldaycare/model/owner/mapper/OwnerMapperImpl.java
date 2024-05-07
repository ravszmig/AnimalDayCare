package pl.animaldaycare.ravsky.animaldaycare.model.owner.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.Owner;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.request.OwnerRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.response.OwnerResponse;

@Component
public class OwnerMapperImpl implements OwnerMapper {

    private final ModelMapper modelMapper;

    public OwnerMapperImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Owner map(OwnerRequest ownerRequest) {
        return modelMapper.map(ownerRequest, Owner.class);
    }

    @Override
    public OwnerResponse map(Owner owner) {
        return modelMapper.map(owner, OwnerResponse.class);
    }
}
