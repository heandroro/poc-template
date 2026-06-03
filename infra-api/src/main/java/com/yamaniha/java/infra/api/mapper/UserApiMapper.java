package com.yamaniha.java.infra.api.mapper;

import com.yamaniha.java.core.domain.User;
import com.yamaniha.java.infra.api.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserApiMapper {

    UserResponse toResponse(User user);
}
