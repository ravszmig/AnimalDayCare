package pl.animaldaycare.ravsky.animaldaycare.model.owner.response;

import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;

import java.util.List;

public record OwnerResponse(
        Long id,
        String name,
        List<Animal> animals
) {}
