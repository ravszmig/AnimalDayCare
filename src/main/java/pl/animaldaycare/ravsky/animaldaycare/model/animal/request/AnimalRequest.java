package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalTypeEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.cats.CatRequest;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.request.dogs.DogRequest;

@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "animalType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DogRequest.class, name = "DOG"),
        @JsonSubTypes.Type(value = CatRequest.class, name = "CAT")
})
@JsonSerialize
public abstract class AnimalRequest {
    private int age;
    private String name;
    private AnimalSizeEnum size;
    private AnimalTypeEnum animalType;

    public abstract Animal map(AnimalRequest animalRequest);
}