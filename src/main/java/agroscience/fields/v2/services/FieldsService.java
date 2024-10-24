package agroscience.fields.v2.services;

import agroscience.fields.v2.entities.FieldV2;
import agroscience.fields.v2.repositories.FieldsRepository;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldsService {

  private final FieldsRepository fieldsRepository;

  public FieldV2 save(FieldV2 field) {
    var fieldId = UUID.randomUUID();
    field.setFieldId(fieldId);
    field.getContours().forEach(c -> {
      c.setContourId(UUID.randomUUID());
      c.setField(field);
    });
    return fieldsRepository.save(field); // try ... catch
  }

}
