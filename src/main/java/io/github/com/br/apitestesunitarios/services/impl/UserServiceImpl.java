package io.github.com.br.apitestesunitarios.services.impl;

import io.github.com.br.apitestesunitarios.domain.User;
import io.github.com.br.apitestesunitarios.domain.dto.UserDTO;
import io.github.com.br.apitestesunitarios.repositories.UserRepository;
import io.github.com.br.apitestesunitarios.services.UserService;
import io.github.com.br.apitestesunitarios.services.exceptions.DataIntegratyViolationException;
import io.github.com.br.apitestesunitarios.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if (user.isPresent()){
            throw new DataIntegratyViolationException("E-mail já cadastrado!");
        }
    }
}
