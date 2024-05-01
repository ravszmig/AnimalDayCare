package pl.animaldaycare.ravsky.animaldaycare.model.animal.cats;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.cats.CatResponse;

@Entity
@Getter
@Setter
public class Cat extends Animal {

    @Column
    CatBreedEnum catBreed;

    @Column
    String specialNeeds;

    public AnimalResponse mapToObj(Animal animal) {
        var cat = (Cat) animal;
        var response = new CatResponse();
        response.setAge(cat.getAge());
        response.setSize(cat.getSize());
        response.setName(cat.getName());
        response.setCatBreed(cat.getCatBreed());
        response.setSpecialNeeds(cat.getSpecialNeeds());
        return response;
    }
}
