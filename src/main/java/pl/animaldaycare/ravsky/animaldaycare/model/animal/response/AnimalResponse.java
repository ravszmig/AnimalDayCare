package pl.animaldaycare.ravsky.animaldaycare.model.animal.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.enums.AnimalSizeEnum;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;

@Getter
@Setter
@JsonSerialize
public abstract class AnimalResponse {
    private int age;
    private String name;
    private AnimalSizeEnum size;
}