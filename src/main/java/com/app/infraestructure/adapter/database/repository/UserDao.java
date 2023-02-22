package com.app.infraestructure.adapter.database.repository;

import com.app.infraestructure.adapter.database.data.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserData, Long> {
}
