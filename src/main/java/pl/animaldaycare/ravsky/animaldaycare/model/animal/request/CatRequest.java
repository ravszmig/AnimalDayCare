package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;

@Getter
@Setter
@JsonSerialize
public class CatRequest extends AnimalRequest {
    private CatBreedEnum catBreed;
    private String specialNeeds;
}