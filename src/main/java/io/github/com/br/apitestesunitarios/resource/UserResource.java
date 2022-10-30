package io.github.com.br.apitestesunitarios.resource;

import io.github.com.br.apitestesunitarios.domain.User;
import io.github.com.br.apitestesunitarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping (value = "/{id}")
    public ResponseEntity<User> findById (@PathVariable Integer id){

        return ResponseEntity.ok().body(userService.findById(id));
    }
}
