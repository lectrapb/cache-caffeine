package com.app.infraestructure.entrypoint.controller;


import com.app.domain.model.User;
import com.app.domain.usecase.searchUser.SearchUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private SearchUserUseCase useCase;


    @GetMapping("/listar")
    public ResponseEntity<List<User>> list() {
        var listUser = useCase.getUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listUser);
    }


    @GetMapping("/listar/{id}")
    public ResponseEntity<User> detail(@PathVariable Long id) throws Exception {
        var user = useCase.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
