package com.yamaniha.java.core.ports.in;

import com.yamaniha.java.core.domain.User;

public interface CreateUserUseCase {

    User execute(String name, String email);
}
