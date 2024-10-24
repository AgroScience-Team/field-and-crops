package agroscience.fields.v2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "soil_compositions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("MemberName")
public class SoilComposition {

  @Id
  @Column(name = "soil_composition_id")
  private UUID soilCompositionId;

  @Column(name = "contour_id")
  private UUID contourId;

  @Column(name = "ph")
  private String ph;

  @Column(name = "sample_date")
  private LocalDate sampleDate;

  @Column(name = "organic_matter")
  private String organicMatter;

  @Column(name = "mobile_p")
  private String mobileP;

  @Column(name = "mobile_k")
  private String mobileK;

  @Column(name = "mobile_s")
  private String mobileS;

  @Column(name = "nitrate_n")
  private String nitrateN;

  @Column(name = "ammonium_n")
  private String ammoniumN;

  @Column(name = "hydrolytic_acidity")
  private String hydrolyticAcidity;

  @Column(name = "ca_exchange")
  private String caExchange;

  @Column(name = "mg_exchange")
  private String mgExchange;

  @Column(name = "b")
  private String b;

  @Column(name = "co")
  private String co;

  @Column(name = "mn")
  private String mn;

  @Column(name = "zn")
  private String zn;
}
