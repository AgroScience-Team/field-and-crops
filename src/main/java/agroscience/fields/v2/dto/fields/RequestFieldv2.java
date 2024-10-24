package agroscience.fields.v2.dto.fields;

import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Data;

@Data
public class RequestFieldv2 {

  private String name;
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$", message = "Ожидается UUID")
  private String seasonId;
  private List<RequestContour> contours;

}
