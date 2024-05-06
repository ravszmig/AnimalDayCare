package pl.animaldaycare.ravsky.animaldaycare.model.owner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

//    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
//    private List<Animal> animals = new ArrayList<>();
}