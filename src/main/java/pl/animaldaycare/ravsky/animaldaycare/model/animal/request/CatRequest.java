package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.animaldaycare.ravsky.animaldaycare.enums.CatBreedEnum;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonSerialize
public class CatRequest extends AnimalRequest {
    @NonNull
    private CatBreedEnum catBreed;
    private String specialNeeds;
}