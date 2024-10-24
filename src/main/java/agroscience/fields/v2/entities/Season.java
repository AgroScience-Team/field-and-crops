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
@Table(name = "seasons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Season {

  @Id
  @Column(name = "season_id")
  private UUID seasonId;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(name = "description")
  private String description;

  @Column(name = "organization_id")
  private UUID organizationId;

}