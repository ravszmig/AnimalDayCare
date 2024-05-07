package pl.animaldaycare.ravsky.animaldaycare.model.owner.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class OwnerResponse {
    private Long id;
    private String name;
    private List<Animal> animals;
}