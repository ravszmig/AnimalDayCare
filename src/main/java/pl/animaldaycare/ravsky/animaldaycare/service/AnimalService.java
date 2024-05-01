package pl.animaldaycare.ravsky.animaldaycare.service;

import org.springframework.stereotype.Service;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Long saveAnimal(AnimalRequest animalRequest) {
        Animal animal = animalRequest.map(animalRequest);
        return animalRepository.save(animal).getId();
    }

    public AnimalResponse getAnimal(Long id) {
        var animal =  animalRepository.findById(id).orElseThrow();
        return animal.mapToObj(animal);
    }
}
