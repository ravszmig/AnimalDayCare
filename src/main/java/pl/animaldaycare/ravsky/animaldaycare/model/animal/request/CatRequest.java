package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.cats.Cat;

@Getter
@Setter
@JsonSerialize
public class CatRequest extends AnimalRequest {
    private CatBreedEnum catBreed;
    private String specialNeeds;

    @Override
    public Animal map(AnimalRequest animalRequest) {
        var catRequest = (CatRequest) animalRequest;
        Cat cat = new Cat();
        cat.setAge(catRequest.getAge());
        cat.setName(catRequest.getName());
        cat.setSize(catRequest.getSize());
        cat.setCatBreed(catRequest.getCatBreed());
        cat.setSpecialNeeds(catRequest.getSpecialNeeds());
        cat.setAnimalType(catRequest.getAnimalType());
        return cat;
    }
}