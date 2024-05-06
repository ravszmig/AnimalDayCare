package pl.animaldaycare.ravsky.animaldaycare.model.owner;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Animal> animals = new ArrayList<>();
}