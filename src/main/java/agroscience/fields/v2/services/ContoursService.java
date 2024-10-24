package agroscience.fields.v2.services;

import agroscience.fields.v2.entities.Contour;
import agroscience.fields.v2.repositories.ContoursRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContoursService {
  private final ContoursRepository contoursRepository;

  public Contour findById(UUID contourId) {
    return contoursRepository.findById(contourId)
            .orElseThrow(() -> new EntityNotFoundException("Contour not found"));
  }

}
