package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalTypeEnum;

@Data
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "animalType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DogRequest.class, name = "DOG"),
        @JsonSubTypes.Type(value = CatRequest.class, name = "CAT")
})
public abstract class AnimalRequest {
    private int age;
    private String name;
    private AnimalSizeEnum size;
    private AnimalTypeEnum animalType;
    private Long ownerId;
}