package pl.animaldaycare.ravsky.animaldaycare.model.animal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalTypeEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.Owner;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class Animal {
    @Id
    @GeneratedValue
    Long id;

    @Column
    @NonNull
    int age;

    @Column
    @NonNull
    String name;

    @Column
    @NonNull
    AnimalSizeEnum size;

    @Column
    @NonNull
    AnimalTypeEnum animalType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
}
