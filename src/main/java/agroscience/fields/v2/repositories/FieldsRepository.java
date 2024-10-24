package agroscience.fields.v2.repositories;

import agroscience.fields.v2.entities.FieldV2;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldsRepository extends JpaRepository<FieldV2, UUID> {

}
