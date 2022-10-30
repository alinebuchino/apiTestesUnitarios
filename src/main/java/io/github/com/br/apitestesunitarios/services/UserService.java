package io.github.com.br.apitestesunitarios.services;

import io.github.com.br.apitestesunitarios.domain.User;
import io.github.com.br.apitestesunitarios.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
}
