package com.gabriel.runnerz;

import com.gabriel.runnerz.run.RunRepository;
import com.gabriel.runnerz.user.User;
import com.gabriel.runnerz.user.UserHttpClient;
import com.gabriel.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    UserHttpClient userHttpClient(){
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(UserHttpClient.class);
    }

    @Bean
    CommandLineRunner runner(UserRestClient restClient, UserHttpClient userHttpClient) {
        return args -> {
            List<User> users = restClient.findAll();
            System.out.println(users);

            User user = restClient.findById(1);
            System.out.println(user);

            List<User> users2 = userHttpClient.findAll();
            System.out.println(users2);

            User user2 = userHttpClient.findById(1);
            System.out.println(user2);
        };
    }
}
