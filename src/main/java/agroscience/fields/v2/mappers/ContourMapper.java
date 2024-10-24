package agroscience.fields.v2.mappers;

import agroscience.fields.dto.field.CoordinatesDTO;
import agroscience.fields.exceptions.WrongCoordinatesException;
import agroscience.fields.v2.dto.fields.RequestContour;
import agroscience.fields.v2.entities.Contour;
import java.util.List;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ContourMapper {

  @Mapping(target = "geom", source = "request.coordinates", qualifiedByName = "mapGeom")
  Contour map(RequestContour request);

  @Named("mapGeom")
  default Geometry mapGeom(List<CoordinatesDTO> coordinates) {
    GeometryFactory geometryFactory = new GeometryFactory();
    // Преобразовать координаты в массив точек
    Coordinate[] polygonCoordinates = new Coordinate[coordinates.size()];
    for (int i = 0; i < coordinates.size(); i++) {
      polygonCoordinates[i] =
              new Coordinate(coordinates.get(i).getLongitude(), coordinates.get(i).getLatitude());
    }
    try {
      return geometryFactory.createPolygon(polygonCoordinates);
    } catch (IllegalArgumentException e) {
      throw new WrongCoordinatesException("Points of polygon do not form a closed linestring");
    }
  }

}
