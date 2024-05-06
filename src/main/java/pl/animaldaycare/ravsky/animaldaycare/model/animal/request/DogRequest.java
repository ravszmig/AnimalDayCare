package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;

@Getter
@Setter
@JsonSerialize
public class DogRequest extends AnimalRequest {
    private DogBreedEnum dogBreed;
    private String specialNeeds;
}