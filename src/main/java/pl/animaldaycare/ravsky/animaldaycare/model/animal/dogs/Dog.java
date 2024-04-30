package pl.animaldaycare.ravsky.animaldaycare.model.animal.dogs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.dogs.DogResponse;

@Entity
@Getter
@Setter
public class Dog extends Animal {

    @Column
    DogBreedEnum dogBreed;

    @Column
    String specialNeeds;

    public AnimalResponse mapToObj(Animal animal) {
        var dog = (Dog) animal;
        var response = new DogResponse();
        response.setAge(dog.getAge());
        response.setSize(dog.getSize());
        response.setName(dog.getName());
        response.setDogBreed(dog.getDogBreed());
        response.setSpecialNeeds(dog.getSpecialNeeds());

        return response;
    }
}
