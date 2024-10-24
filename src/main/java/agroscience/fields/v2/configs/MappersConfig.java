package agroscience.fields.v2.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
