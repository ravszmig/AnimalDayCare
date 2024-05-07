package pl.animaldaycare.ravsky.animaldaycare.model.animal.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import pl.animaldaycare.ravsky.animaldaycare.enums.DogBreedEnum;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonSerialize
public class DogRequest extends AnimalRequest {
    @NonNull
    private DogBreedEnum dogBreed;
    private String specialNeeds;
}