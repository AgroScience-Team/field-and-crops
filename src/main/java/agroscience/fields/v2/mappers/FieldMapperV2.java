package agroscience.fields.v2.mappers;

import agroscience.fields.v2.dto.fields.RequestFieldv2;
import agroscience.fields.v2.entities.FieldV2;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ContourMapper.class})
public interface FieldMapperV2 {

  FieldV2 map(RequestFieldv2 request);

}
