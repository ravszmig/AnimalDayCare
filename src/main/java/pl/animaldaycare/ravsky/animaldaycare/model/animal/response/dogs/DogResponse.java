package pl.animaldaycare.ravsky.animaldaycare.model.animal.response.dogs;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;

@Getter
@Setter
@JsonSerialize
public class DogResponse extends AnimalResponse {
    private DogBreedEnum dogBreed;
    private String specialNeeds;
}