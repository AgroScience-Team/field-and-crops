package agroscience.fields.v2.dto.soilcompositions;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
@SuppressWarnings("MemberName")
public class RequestSoilComposition {

  private String ph;
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$", message = "Ожидается UUID")
  private String contourId;
  private LocalDate sampleDate;
  private String organicMatter;
  private String mobileP;
  private String mobileK;
  private String mobileS;
  private String nitrateN;
  private String ammoniumN;
  private String hydrolyticAcidity;
  private String caExchange;
  private String mgExchange;
  private String b;
  private String co;
  private String mn;
  private String zn;

}
