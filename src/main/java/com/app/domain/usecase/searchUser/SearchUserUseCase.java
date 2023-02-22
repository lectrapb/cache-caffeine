package com.app.domain.usecase.searchUser;

import com.app.domain.model.User;
import com.app.domain.model.gateway.IUserService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SearchUserUseCase {

    private IUserService userService;

    public List<User> getUsers() {

        return userService.findAll();
    }


    public User getUserById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Null parameter");
        }
        return userService.findById(id);
    }
}
