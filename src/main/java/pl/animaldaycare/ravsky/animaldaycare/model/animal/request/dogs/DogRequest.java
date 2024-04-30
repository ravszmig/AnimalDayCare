package pl.animaldaycare.ravsky.animaldaycare.model.animal.request.dogs;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.dogs.Dog;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;

@Getter
@Setter
@JsonSerialize
public class DogRequest extends AnimalRequest {
    private DogBreedEnum dogBreed;
    private String specialNeeds;

    public Dog map(AnimalRequest animalRequest) {
        var dogRequest = (DogRequest) animalRequest;
        Dog dog = new Dog();
        dog.setAge(dogRequest.getAge());
        dog.setName(dogRequest.getName());
        dog.setSize(dogRequest.getSize());
        dog.setDogBreed(dogRequest.getDogBreed());
        dog.setSpecialNeeds(dogRequest.getSpecialNeeds());
        return dog;
    }
}