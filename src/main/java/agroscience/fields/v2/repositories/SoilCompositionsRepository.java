package agroscience.fields.v2.repositories;

import agroscience.fields.v2.entities.SoilComposition;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilCompositionsRepository extends JpaRepository<SoilComposition, UUID> {

}
