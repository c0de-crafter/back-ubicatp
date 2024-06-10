package com.cico.backubicatp.service;

import com.cico.backubicatp.model.User;
import com.cico.backubicatp.repo.IUserRepo;
import com.cico.backubicatp.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private IUserRepo repo;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImpl service;

    private User USER_1;
    private User USER_2;
    private User USER_3;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new UserServiceImpl(repo, passwordEncoder);

        USER_1 = new User(1, "user1@example.com", "password1", "User", "One", "user1.png", "ROLE_USER");
        USER_2 = new User(2, "user2@example.com", "password2", "User", "Two", "user2.png", "ROLE_USER");
        USER_3 = new User(3, "user3@example.com", "password3", "User", "Three", "user3.png", "ROLE_USER");

        List<User> users = List.of(USER_1, USER_2, USER_3);

        when(repo.findAll()).thenReturn(users);
        when(repo.findById(any())).thenReturn(Optional.of(USER_1));
        when(repo.save(any())).thenReturn(USER_1);
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
    }

    @Test
    void readAllTest() throws Exception {
        List<User> response = service.readAll();
        assertEquals(3, response.size());
    }

    @Test
    void readByIdTest() throws Exception {
        final int ID = 1;
        User response = service.readById(ID);
        assertNotNull(response);
    }

    @Test
    void saveTest() throws Exception {
        User response = service.save(USER_1);
        assertNotNull(response);
        assertEquals("encodedPassword", response.getPassword());
    }

    @Test
    void updateTest() throws Exception {
        User response = service.update(USER_1, USER_1.getIdUser());
        assertNotNull(response);
        assertEquals("encodedPassword", response.getPassword());
    }

    @Test
    void deleteTest() throws Exception {
        final int ID = 1;
        service.delete(ID);
        verify(repo, times(1)).deleteById(ID);
    }
}
