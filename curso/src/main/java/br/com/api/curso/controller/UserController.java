package br.com.api.curso.controller;

import br.com.api.curso.model.UserModel;
import br.com.api.curso.model.dto.UserModelDTO;
import br.com.api.curso.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModelDTO>> userList() {
        return ResponseEntity.ok().body(userService.findByAll());
    }

    @PostMapping("/created")
    public ResponseEntity<UserModelDTO> save(@Valid @RequestBody UserModel userModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

}
