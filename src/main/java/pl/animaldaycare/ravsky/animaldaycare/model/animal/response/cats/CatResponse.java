package pl.animaldaycare.ravsky.animaldaycare.model.animal.response.cats;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.response.AnimalResponse;

@Getter
@Setter
@JsonSerialize
public class CatResponse extends AnimalResponse {
    private CatBreedEnum catBreed;
    private String specialNeeds;
}