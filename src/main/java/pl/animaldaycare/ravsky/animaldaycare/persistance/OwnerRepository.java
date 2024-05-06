package pl.animaldaycare.ravsky.animaldaycare.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.animaldaycare.ravsky.animaldaycare.model.owner.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}