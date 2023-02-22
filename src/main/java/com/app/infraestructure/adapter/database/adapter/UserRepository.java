package com.app.infraestructure.adapter.database.adapter;

import com.app.domain.model.User;
import com.app.domain.model.gateway.IUserService;
import com.app.infraestructure.adapter.database.data.UserData;
import com.app.infraestructure.adapter.database.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository implements IUserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);

    private final UserDao userDao;
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Cacheable("users_cache")
    public List<User> findAll() {

        LOG.info("get information logs  ");
        List<UserData> usersData = (List<UserData>)userDao.findAll();
        List<User> users = new ArrayList<>();

        usersData.forEach(userData -> {
            User user = new User();
            user.setId(userData.getId());
            user.setName(userData.getName());
            user.setCreateAt(userData.getCreateAt());
            users.add(user);
        });
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {

        UserData userData = userDao.findById(id).orElse(null);
        User user = new User();

        if(userData != null){
            user.setId(userData.getId());
            user.setName(userData.getName());
            user.setCreateAt(userData.getCreateAt());
        }

        return user;
    }
}
