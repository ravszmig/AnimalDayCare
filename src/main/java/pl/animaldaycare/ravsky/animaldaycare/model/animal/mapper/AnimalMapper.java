package pl.animaldaycare.ravsky.animaldaycare.model.animal.mapper;

import org.springframework.stereotype.Component;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;

@Component
public interface AnimalMapper {
    Animal map(AnimalRequest animalRequest);
    AnimalResponse map(Animal animal);
}