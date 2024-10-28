package com.gabriel.runnerz;

import com.gabriel.runnerz.run.RunRepository;
import com.gabriel.runnerz.user.User;
import com.gabriel.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRestClient restClient) {
        return args -> {
            List<User> users = restClient.findAll();
            System.out.println(users);

            User user = restClient.findById(1);
            System.out.println(user);
        };
    }
}
