package pl.animaldaycare.ravsky.animaldaycare.model.animal.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Cat;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Dog;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.CatResponse;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.DogResponse;

@Component
public class AnimalMapperImpl implements AnimalMapper {

    private final ModelMapper modelMapper;

    public AnimalMapperImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Animal map(AnimalRequest animalRequest) {
        return switch (animalRequest.getAnimalType()) {
            case DOG -> modelMapper.map(animalRequest, Dog.class);
            case CAT -> modelMapper.map(animalRequest, Cat.class);
            default -> throw new IllegalArgumentException("Invalid animal type");
        };
    }

    @Override
    public AnimalResponse map(Animal animal) {
        return switch (animal.getAnimalType()) {
            case DOG -> modelMapper.map(animal, DogResponse.class);
            case CAT -> modelMapper.map(animal, CatResponse.class);
            default -> throw new IllegalArgumentException("Invalid animal type");
        };
    }
}
