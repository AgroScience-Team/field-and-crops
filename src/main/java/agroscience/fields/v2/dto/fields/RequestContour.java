package agroscience.fields.v2.dto.fields;

import agroscience.fields.dto.field.CoordinatesDTO;
import java.util.List;
import lombok.Data;

@Data
public class RequestContour {

  private String color;
  private String squareArea;
  private List<CoordinatesDTO> coordinates;

}
