package agroscience.fields.v2.controllers;

import agroscience.fields.v2.dto.seasons.RequestSeason;
import agroscience.fields.v2.dto.seasons.ResponseSeason;
import agroscience.fields.v2.entities.Season;
import agroscience.fields.v2.security.TokenUserContext;
import agroscience.fields.v2.services.SeasonsService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v2/fields/seasons")
public class SeasonsController {

  private final SeasonsService seasonsService;
  private final ModelMapper modelMapper;

  @PostMapping
  @PreAuthorize("hasRole('organization') or hasRole('worker')")
  public ResponseSeason save(
          final @AuthenticationPrincipal TokenUserContext token,
          @Valid @RequestBody RequestSeason request
  ) {
    var season = modelMapper.map(request, Season.class);
    season.setOrganizationId(token.orgId());
    var seasonEntity = seasonsService.save(season);
    return modelMapper.map(seasonEntity, ResponseSeason.class);
  }

  @GetMapping
  @PreAuthorize("hasRole('organization') or hasRole('worker')")
  public List<Season> getAll(final @AuthenticationPrincipal TokenUserContext token) {
    return seasonsService.getAll(token.orgId());
  }

}