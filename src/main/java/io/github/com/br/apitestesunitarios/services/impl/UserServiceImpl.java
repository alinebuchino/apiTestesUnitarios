package io.github.com.br.apitestesunitarios.services.impl;

import io.github.com.br.apitestesunitarios.domain.User;
import io.github.com.br.apitestesunitarios.repositories.UserRepository;
import io.github.com.br.apitestesunitarios.services.UserService;
import io.github.com.br.apitestesunitarios.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }
}
