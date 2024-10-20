package agroscience.fields.v2.controllers;

import agroscience.fields.v2.dto.fields.RequestFieldv2;
import agroscience.fields.v2.mappers.FieldMapperV2;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "api/v2/fields/fields")
@RequiredArgsConstructor
public class FieldsContoursController {

  private final ModelMapper modelMapper;
  private final FieldMapperV2 fieldMapperV2;

  @PostMapping
  public void save(@Valid @RequestBody RequestFieldv2 field) {
    //log.info("recive {}",modelMapper.map(field, Fields.class));
    var a = fieldMapperV2.map(field);
    return;
  }

}
