package com.yamaniha.java.core.ports.in;

import com.yamaniha.java.core.domain.User;

import java.util.UUID;

public interface FindUserUseCase {

    User execute(UUID id);
}
