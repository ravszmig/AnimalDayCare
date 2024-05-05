package pl.animaldaycare.ravsky.animaldaycare.model.animal.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;

@Getter
@Setter
@JsonSerialize
public class DogResponse extends AnimalResponse {
    private DogBreedEnum dogBreed;
    private String specialNeeds;
}