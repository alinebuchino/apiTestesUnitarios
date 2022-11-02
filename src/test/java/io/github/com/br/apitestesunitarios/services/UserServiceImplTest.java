package io.github.com.br.apitestesunitarios.services;

import io.github.com.br.apitestesunitarios.domain.User;
import io.github.com.br.apitestesunitarios.domain.dto.UserDTO;
import io.github.com.br.apitestesunitarios.repositories.UserRepository;
import io.github.com.br.apitestesunitarios.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Aline";
    public static final String EMAIL = "aline@gmail.com";
    public static final String PASSWORD = "123";

    @InjectMocks // cria uma instancia de verdade da classe, para pegar valores reais
    private UserServiceImpl service;

    @Mock // cria uma instancia de `mentira` para usar de exemplo
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;
    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance(){
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    void startUser(){
        user = new User(ID, NOME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NOME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NOME, EMAIL, PASSWORD));
    }
}