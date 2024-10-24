package agroscience.fields.v2.controllers;

import agroscience.fields.v2.dto.soilcompositions.RequestSoilComposition;
import agroscience.fields.v2.dto.soilcompositions.ResponseSoilComposition;
import agroscience.fields.v2.entities.SoilComposition;
import agroscience.fields.v2.services.SoilCompositionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v2/fields/soilCompositions") // TODO Replace with api/v2/fields/soil-compositions
public class SoilCompositionsController {

  private final ModelMapper modelMapper;
  private final SoilCompositionsService soilCompositionsService;

  @PostMapping
  @PreAuthorize("hasRole('organization') or hasRole('worker')")
  public ResponseSoilComposition save(
          @Valid @RequestBody RequestSoilComposition request
  ){
    var soilComposition = modelMapper.map(request, SoilComposition.class);
    var soilCompositionEntity = soilCompositionsService.save(soilComposition);
    return modelMapper.map(soilCompositionEntity, ResponseSoilComposition.class);
  }
  @GetMapping
  @PreAuthorize("hasRole('organization') or hasRole('worker')")
  public SoilComposition get(@Valid UUID soilCompositionId){
    return soilCompositionsService.findById(soilCompositionId);
  }
}
