package pl.animaldaycare.ravsky.animaldaycare.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}