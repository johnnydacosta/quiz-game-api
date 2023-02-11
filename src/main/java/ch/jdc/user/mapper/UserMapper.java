package ch.jdc.user.mapper;

import ch.jdc.domain.User;
import ch.jdc.user.api.UserCreateForm;
import ch.jdc.user.dto.UserDto;
import ch.jdc.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapToDto(User user);

    User mapToDomain(UserEntity user);

    User mapToDomain(UserCreateForm userCreateForm);

    UserEntity mapToEntity(User user);

}
