package com.yamaniha.java.core.usecase;

import com.yamaniha.java.core.domain.User;
import com.yamaniha.java.core.ports.in.CreateUserUseCase;
import com.yamaniha.java.core.ports.out.UserRepositoryPort;
import jakarta.inject.Named;

import java.time.LocalDateTime;
import java.util.UUID;

@Named
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public CreateUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User execute(String name, String email) {
        if (userRepositoryPort.existsByEmail(email)) {
            throw new IllegalArgumentException("A user with email '" + email + "' already exists.");
        }

        User user = new User(UUID.randomUUID(), name, email, LocalDateTime.now());
        return userRepositoryPort.save(user);
    }
}
