package com.app.config;

import com.app.domain.usecase.searchUser.SearchUserUseCase;
import com.app.infraestructure.adapter.database.adapter.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {


    @Bean
    public SearchUserUseCase searchUserUseCase( UserRepository repository){
        return new SearchUserUseCase(repository);
    }
}
