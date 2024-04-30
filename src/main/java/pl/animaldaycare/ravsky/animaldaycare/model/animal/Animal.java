package pl.animaldaycare.ravsky.animaldaycare.model.animal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalTypeEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class Animal {
    @Id
    @GeneratedValue
    Long id;

    @Column
    int age;

    @Column
    String name;

    @Column
    AnimalSizeEnum size;

    @Column
    AnimalTypeEnum animalType;

    public abstract AnimalResponse mapToObj(Animal animal);
}
