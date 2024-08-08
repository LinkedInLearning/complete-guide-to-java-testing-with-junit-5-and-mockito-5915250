package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService underTest;

    @Test
    public void getUserById() throws Exception {
        User mockUser = new User("123", "John Doe");
        when(userRepository.findById("123")).thenReturn(mockUser);

        CompletableFuture<User> future = underTest.getUserById("123");

        User result = future.get();
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("123", result.getId());
        verify(userRepository).findById("123");
    }
}