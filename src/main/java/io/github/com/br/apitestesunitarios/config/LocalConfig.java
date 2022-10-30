package io.github.com.br.apitestesunitarios.config;

import io.github.com.br.apitestesunitarios.domain.User;
import io.github.com.br.apitestesunitarios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        User u1 = new User(null, "Aline", "aline@mail.com", "123");
        User u2 = new User(null, "Buchino", "buchino@mail.com", "456");

        repository.saveAll(List.of(u1, u2));
    }
}
