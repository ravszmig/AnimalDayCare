package pl.animaldaycare.ravsky.animaldaycare.service;

import org.springframework.stereotype.Service;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.mapper.AnimalMapper;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.persistance.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    public AnimalService(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }

    public Long saveAnimal(AnimalRequest animalRequest) {
        Animal animal = animalMapper.map(animalRequest);
        return animalRepository.save(animal).getId();
    }

    public AnimalResponse getAnimal(Long id) {
        var animal = animalRepository.findById(id).orElseThrow();
        return animalMapper.map(animal);
    }
}
