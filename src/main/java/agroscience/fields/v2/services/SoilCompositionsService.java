package agroscience.fields.v2.services;

import agroscience.fields.v2.entities.SoilComposition;
import agroscience.fields.v2.repositories.SoilCompositionsRepository;

import java.util.UUID;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SoilCompositionsService {

  private final SoilCompositionsRepository soilCompositionsRepository;

  public SoilComposition save(SoilComposition soilComposition) {
    var soilCompositionId = UUID.randomUUID();
    soilComposition.setSoilCompositionId(soilCompositionId);
    return soilCompositionsRepository.save(soilComposition);
  }
  public SoilComposition findById(UUID soilCompositionId) {
    return soilCompositionsRepository.findById(soilCompositionId)
            .orElseThrow(() -> new EntityNotFoundException("SoilComposition not found"));
  }

}
