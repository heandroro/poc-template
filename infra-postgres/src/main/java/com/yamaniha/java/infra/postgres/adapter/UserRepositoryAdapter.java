package com.yamaniha.java.infra.postgres.adapter;

import com.yamaniha.java.core.domain.User;
import com.yamaniha.java.core.ports.out.UserRepositoryPort;
import com.yamaniha.java.infra.postgres.mapper.UserPostgresMapper;
import com.yamaniha.java.infra.postgres.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final UserPostgresMapper userPostgresMapper;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository, UserPostgresMapper userPostgresMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userPostgresMapper = userPostgresMapper;
    }

    @Override
    public User save(User user) {
        return userPostgresMapper.toDomain(
                userJpaRepository.save(userPostgresMapper.toEntity(user))
        );
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpaRepository.findById(id)
                .map(userPostgresMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }
}
