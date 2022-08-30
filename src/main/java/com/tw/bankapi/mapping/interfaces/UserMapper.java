package com.tw.bankapi.mapping.interfaces;

import com.tw.bankapi.entities.UsersEntity;
import com.tw.bankapi.mapping.dto.UserDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "userName", source = "nameUser"),
            @Mapping(target = "userState", source = "stateUser"),
    })
    UserDTO entityToDto(UsersEntity usersEntity);

    List<UserDTO> map(List<UsersEntity> usersEntityList);
}
