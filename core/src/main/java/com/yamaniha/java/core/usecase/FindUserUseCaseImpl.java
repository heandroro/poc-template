package com.yamaniha.java.core.usecase;

import com.yamaniha.java.core.domain.User;
import com.yamaniha.java.core.ports.in.FindUserUseCase;
import com.yamaniha.java.core.ports.out.UserRepositoryPort;
import jakarta.inject.Named;

import java.util.UUID;

@Named
public class FindUserUseCaseImpl implements FindUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public FindUserUseCaseImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User execute(UUID id) {
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
}
