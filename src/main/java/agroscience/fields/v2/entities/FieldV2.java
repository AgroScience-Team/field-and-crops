package agroscience.fields.v2.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "fields")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FieldV2 {
  @Id
  @Column(name = "field_id")
  private UUID fieldId;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "season_id")
  private UUID seasonId;

  @OneToMany(mappedBy = "field", cascade = {CascadeType.PERSIST, CascadeType.MERGE},
          fetch = FetchType.EAGER, orphanRemoval = true) // FetchType - сразу запрос на поля или нет
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Contour> contours;
}
