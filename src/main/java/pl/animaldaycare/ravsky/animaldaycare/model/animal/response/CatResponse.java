package pl.animaldaycare.ravsky.animaldaycare.model.animal.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;

@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@JsonSerialize
public class CatResponse extends AnimalResponse {
    private CatBreedEnum catBreed;
    private String specialNeeds;
}