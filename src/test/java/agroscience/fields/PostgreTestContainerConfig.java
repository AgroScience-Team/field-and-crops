package agroscience.fields;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.utility.DockerImageName;

@Slf4j
public class PostgreTestContainerConfig {

  private static volatile PostgreSQLContainer<?> postgreSQLContainer = null;

  private static PostgreSQLContainer<?> getPostgreSQLContainer() {
    PostgreSQLContainer<?> instance = postgreSQLContainer;
    if (instance == null) {
      DockerImageName myImage = DockerImageName.parse("postgis/postgis:15-3.4-alpine").asCompatibleSubstituteFor("postgres");
      synchronized (PostgreSQLContainer.class) {
        postgreSQLContainer = instance =
                new PostgreSQLContainer<>(myImage)
                        .withReuse(true)
                        .withLogConsumer(new Slf4jLogConsumer(log))
                        .withStartupTimeout(Duration.ofSeconds(60));
        postgreSQLContainer.start();
      }
    }
    return instance;
  }

  @Component("PostgresInitializer")
  public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      var postgreSQLContainer = getPostgreSQLContainer();
      TestPropertyValues.of(
              "DB_URL: " + postgreSQLContainer.getJdbcUrl(),
              "POSTGRESQL_USERNAME: " + postgreSQLContainer.getUsername(),
              "POSTGRESQL_PASSWORD: " + postgreSQLContainer.getPassword()
      ).applyTo(configurableApplicationContext.getEnvironment());
    }

  }

}
