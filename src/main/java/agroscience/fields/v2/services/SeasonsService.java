package agroscience.fields.v2.services;

import agroscience.fields.v2.entities.Season;
import agroscience.fields.v2.repositories.SeasonsRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeasonsService {

  private final SeasonsRepository seasonsRepository;

  public Season save(Season season) {
    var seasonId = UUID.randomUUID();
    season.setSeasonId(seasonId);
    return seasonsRepository.save(season);
  }

  public List<Season> getAll(UUID organizationId) {
    return seasonsRepository.getAllByOrganizationId(organizationId);
  }

}
