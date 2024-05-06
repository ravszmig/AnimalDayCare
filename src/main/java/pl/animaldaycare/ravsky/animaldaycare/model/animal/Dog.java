package pl.animaldaycare.ravsky.animaldaycare.model.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;

@Entity
@Getter
@Setter
public class Dog extends Animal {

    @Column
    DogBreedEnum dogBreed;

    @Column
    String specialNeeds;
}
