package com.app.domain.usecase.searchUser;

import com.app.domain.model.User;
import com.app.domain.model.gateway.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SearchUserUseCaseTest {


    private IUserService userService;
    private SearchUserUseCase useCase;
    @BeforeEach
    void setUp() {
        userService = mock(IUserService.class);
        useCase = new SearchUserUseCase(userService);
    }


    @Test
    void user_search_ok(){
        //Given
        List<User> users = new ArrayList<>();
        when(userService.findAll()).thenReturn(users);
        //When
        var result = useCase.getUsers();
        //Then
        assertNotNull(result);
    }

    @Test
    void user_search_by_id_null(){

        var result = assertThrows(Exception.class, () ->{
             useCase.getUserById(null);
        });
        //Then
        assertEquals("Null parameter", result.getMessage());
    }

    @Test
    void user_search_by_id_ok () throws Exception {
        //Given
        User user = new User();
        when(userService.findById(any(Long.class))).thenReturn(user);
        //When
        var result = useCase.getUserById(1L);
        //Then
        assertNotNull(result);
    }
}