package io.github.com.br.apitestesunitarios.repositories;

import io.github.com.br.apitestesunitarios.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
