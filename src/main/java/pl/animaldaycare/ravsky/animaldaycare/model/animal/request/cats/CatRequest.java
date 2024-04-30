package pl.animaldaycare.ravsky.animaldaycare.model.animal.request.cats;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.cats.Cat;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.AnimalRequest;

@Getter
@Setter
@JsonSerialize
public class CatRequest extends AnimalRequest {
    private DogBreedEnum dogBreed;
    private String specialNeeds;

    @Override
    public Animal map(AnimalRequest animalRequest) {
        var catRequest = (CatRequest) animalRequest;
        Cat cat = new Cat();
        cat.setAge(catRequest.getAge());
        cat.setName(catRequest.getName());
        cat.setSize(catRequest.getSize());
        cat.setCatBreed(catRequest.getDogBreed());
        cat.setSpecialNeeds(catRequest.getSpecialNeeds());
        return cat;
    }
}