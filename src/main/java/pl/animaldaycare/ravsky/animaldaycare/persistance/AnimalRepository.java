package pl.animaldaycare.ravsky.animaldaycare.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.animaldaycare.ravsky.animaldaycare.model.animal.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findAllByOwnerId(Long ownerId);
}