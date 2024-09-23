package dev.praneeth.backend.hospitalization;

/*import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;*/
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalizationConfig {

   /*  @Bean
    CommandLineRunner commandLineRunner(HospitalizationRepository hospitalizationRepository) {
        return args -> {
            Hospitalization hospitalization1 = new Hospitalization(LocalDate.of(2024, 9, 15), LocalDate.of(2024, 9, 20), "Pneumonia", "Stable at discharge.", 12345);
            Hospitalization hospitalization2 = new Hospitalization(LocalDate.of(2024, 9, 10), null, "Surgery", "Post-op care required.", 54321);
            Hospitalization hospitalization3 = new Hospitalization(LocalDate.of(2024, 9, 12), LocalDate.of(2024, 9, 15), "Observation", "Monitoring required.", 67890);

            hospitalizationRepository.saveAll(List.of(hospitalization1, hospitalization2, hospitalization3));
        };
    }*/
}
