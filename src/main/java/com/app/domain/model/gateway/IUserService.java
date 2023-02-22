package com.app.domain.model.gateway;

import com.app.domain.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);

}
