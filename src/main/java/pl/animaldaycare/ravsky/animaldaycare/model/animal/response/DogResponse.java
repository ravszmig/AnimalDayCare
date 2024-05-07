package pl.animaldaycare.ravsky.animaldaycare.model.animal.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;

@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@JsonSerialize
public class DogResponse extends AnimalResponse {
    private DogBreedEnum dogBreed;
    private String specialNeeds;
}