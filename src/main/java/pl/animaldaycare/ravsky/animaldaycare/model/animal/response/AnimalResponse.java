package pl.animaldaycare.ravsky.animaldaycare.model.animal.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalTypeEnum;

@EqualsAndHashCode
@Data
@JsonSerialize
public abstract class AnimalResponse {
    private int age;
    private String name;
    private AnimalSizeEnum size;
    private AnimalTypeEnum animalType;
    private Long ownerId;
}