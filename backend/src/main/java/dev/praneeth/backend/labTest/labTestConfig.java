package dev.praneeth.backend.user;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabTestConfig {

    @Bean
    CommandLineRunner commandLineRunner(LabTestRepository labTestRepository) {
        return args -> {
            LabTest test1 = new LabTest("Complete Blood Count", "A test that evaluates overall health and detects a variety of disorders, such as anemia and infection.", "4.5-11.0 x 10^9/L", "cells/L");
            LabTest test2 = new LabTest("Liver Function Test", "Measures various enzymes and proteins in the blood to assess liver health.", "ALT: 7-56 U/L, AST: 5-40 U/L", "U/L");
            LabTest test3 = new LabTest("Thyroid Function Test", "Measures thyroid hormones to assess thyroid health.", "TSH: 0.4-4.0 mIU/L", "mIU/L");

            labTestRepository.saveAll(List.of(test1, test2, test3));
        };
    }
}
