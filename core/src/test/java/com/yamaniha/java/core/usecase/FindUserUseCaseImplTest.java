package com.yamaniha.java.core.usecase;

import com.yamaniha.java.core.domain.User;
import com.yamaniha.java.core.ports.out.UserRepositoryPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUserUseCaseImplTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    @InjectMocks
    private FindUserUseCaseImpl findUserUseCase;

    @Test
    void execute_shouldReturnUser_whenFound() {
        var user = Instancio.create(User.class);
        when(userRepositoryPort.findById(user.id())).thenReturn(Optional.of(user));

        var result = findUserUseCase.execute(user.id());

        assertThat(result).isEqualTo(user);
    }

    @Test
    void execute_shouldThrow_whenNotFound() {
        var id = UUID.randomUUID();
        when(userRepositoryPort.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> findUserUseCase.execute(id))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(id.toString());
    }
}
