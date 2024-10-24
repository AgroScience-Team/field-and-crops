package agroscience.fields.v2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "contours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contour {

  @Id
  @Column(name = "contour_id")
  private UUID contourId;

  @Column(name = "square_area", length = 40, nullable = false)
  private String squareArea;

  @Column(name = "geom", nullable = false, columnDefinition = "geometry(Geometry,0)")
  private Geometry geom; // Тип Geometry для хранения геометрических данных

  @Column(name = "description", length = 256)
  private String description;

  @Column(name = "color", length = 6, nullable = false)
  private String color;

  @ManyToOne
  @JoinColumn(name = "field_id")
  private FieldV2 field;

}
