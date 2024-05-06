package pl.animaldaycare.ravsky.animaldaycare.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.mapper.AnimalMapper;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.persistance.AnimalRepository;
import pl.animaldaycare.ravsky.animaldaycare.persistance.OwnerRepository;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final OwnerRepository ownerRepository;
    private final AnimalMapper animalMapper;

    public AnimalService(AnimalRepository animalRepository, AnimalMapper animalMapper, OwnerRepository ownerRepository) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
        this.ownerRepository = ownerRepository;
    }

    public Long saveAnimal(AnimalRequest animalRequest) {
        var owner = ownerRepository.findById(animalRequest.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException("Owner not found"));

        Animal animal = animalMapper.map(animalRequest);
        animal.setOwner(owner);

        return animalRepository.save(animal).getId();
    }

    public AnimalResponse getAnimal(Long id) {
        var animal = animalRepository.findById(id).orElseThrow();
        return animalMapper.map(animal);
    }
}
