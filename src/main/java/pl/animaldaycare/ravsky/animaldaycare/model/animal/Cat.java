package pl.animaldaycare.ravsky.animaldaycare.model.animal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;

@Entity
@Getter
@Setter
public class Cat extends Animal {

    @Column
    CatBreedEnum catBreed;

    @Column
    String specialNeeds;
}
