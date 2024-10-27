package com.gabriel.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    CommandLineRunner runner(RunRepository runRepository) {
//        return args -> {
//            Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now()
//                    .plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
//            runRepository.create(run);
//        };
//    }
}
