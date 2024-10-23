package agroscience.fields.v2.dto.seasons;

import java.time.LocalDate;
import lombok.Data;

@Data
public class RequestSeasons {

  private LocalDate startDate;
  private LocalDate endDate;
  private String description;

}