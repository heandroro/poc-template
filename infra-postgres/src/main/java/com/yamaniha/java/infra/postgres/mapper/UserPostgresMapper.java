package com.yamaniha.java.infra.postgres.mapper;

import com.yamaniha.java.core.domain.User;
import com.yamaniha.java.infra.postgres.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserPostgresMapper {

    UserEntity toEntity(User user);

    User toDomain(UserEntity entity);
}
