package io.github.com.br.apitestesunitarios.services;

import io.github.com.br.apitestesunitarios.domain.User;

public interface UserService {

    User findById(Integer id);
}
