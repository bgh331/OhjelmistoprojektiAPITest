package ohjelmistoprojektiAPI.ohjelmistoprojektiAPI.domain;


import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
@Slf4j
class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  @Bean
  CommandLineRunner initDatabase(KyselyRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Kysely("Kuinka monta Banaania on Kasperilla?", "100", "50", "10", "1")));
      log.info("Preloading " + repository.save(new Kysely("Kuinka monta hedelmää tarvitaan kasvattaa puu?", "kolme", "kaksi", "yksi")));
    };
  }
}