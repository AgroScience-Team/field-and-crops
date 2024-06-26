package agroscience.fields.mappers;

import agroscience.fields.dao.models.FandCRandC;
import agroscience.fields.dao.entities.CropRotation;
import agroscience.fields.dto.croprotation.*;
import agroscience.fields.utilities.LocalDateConverting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring", uses = CropMapper.class)
public interface CropRotationMapper{

    @Mapping(target = "cropRotationStartDate", source = "cropRotationStartDate", qualifiedByName = "localDateToString")
    @Mapping(target = "cropRotationEndDate", source = "cropRotationEndDate", qualifiedByName = "localDateToString")
    @Mapping(target = "cropName", source = "crop", qualifiedByName = "cropName")
    List<ResponseCRForF> cropRotationToCropRotationResponse(List<CropRotation> cropRotations);
    @Mapping(target = "cropRotations", source = "cropRotationResponses")
    ResponseListCropRotationsForField cropRotationsToList(Long fieldId,
                                                          List<ResponseCRForF> cropRotationResponses);

    @Mapping(target = "cropRotationStartDate", source = "dto.cropRotation.cropRotationStartDate", qualifiedByName = "localDateToString")
    @Mapping(target = "cropRotationEndDate", source = "dto.cropRotation.cropRotationEndDate", qualifiedByName = "localDateToString")
    @Mapping(target = "crop", source = "dto.crop")
    @Mapping(target = "cropRotationId", source = "dto.cropRotation.cropRotationId")
    @Mapping(target = "cropRotationDescription", source = "dto.cropRotation.cropRotationDescription")
    @Mapping(target = "field", source = "dto.field")
    ResponseCRWithField responseCRWithField(FandCRandC dto);

    @Mapping(target = "cropRotationStartDate", source = "cropRotationStartDate", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "cropRotationEndDate", source = "cropRotationEndDate", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "field", ignore = true)
    @Mapping(target = "crop", ignore = true)
    CropRotation CropRotatopnRequestToCropRotation(RequestCropRotation request);
    @Named("localDateToString")
    default String localDateToString(LocalDate date){
        return LocalDateConverting.localDateToString(date);
    }

    @Named("stringToLocalDate")
    default LocalDate localDateToString(String date) throws ParseException {
        return LocalDateConverting.stringToLocalDate(date);
    }

    @Mapping(target = "cropRotationId", ignore = true)
    @Mapping(target = "field", ignore = true)
    @Mapping(target = "crop", ignore = true)
    void newCRToCR(@MappingTarget CropRotation cropRotation, CropRotation newCropRotation);
}
