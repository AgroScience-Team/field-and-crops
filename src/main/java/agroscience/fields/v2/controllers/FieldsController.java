package agroscience.fields.v2.controllers;

import agroscience.fields.v2.dto.fields.RequestFieldv2;
import agroscience.fields.v2.dto.fields.ResponseField;
import agroscience.fields.v2.mappers.FieldMapperV2;
import agroscience.fields.v2.services.FieldsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "api/v2/fields/fields")
@RequiredArgsConstructor
public class FieldsController {

  private final FieldMapperV2 fieldMapperV2;
  private final FieldsService fieldService;
  private final ModelMapper modelMapper;

  @PostMapping
  @PreAuthorize("hasRole('organization') or hasRole('worker')")
  public ResponseField save(@Valid @RequestBody RequestFieldv2 field) {
    var fieldEntity = fieldMapperV2.map(field);
    var savedFieldEntity = fieldService.save(fieldEntity);
    return modelMapper.map(savedFieldEntity, ResponseField.class);
  }

}
