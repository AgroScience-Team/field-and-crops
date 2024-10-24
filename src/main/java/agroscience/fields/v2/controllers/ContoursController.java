package agroscience.fields.v2.controllers;

import agroscience.fields.v2.entities.Contour;
import agroscience.fields.v2.services.ContoursService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@Slf4j
@RestController
@RequestMapping(path = "api/v2/fields/contours")
@RequiredArgsConstructor
public class ContoursController {

  private final ContoursService contourService;

  @GetMapping("/{contourId}")
  @PreAuthorize("hasRole('organization') or hasRole('worker')")
  public Contour get(@Valid @PathVariable UUID contourId) {
    return contourService.findById(contourId);
  }

}
