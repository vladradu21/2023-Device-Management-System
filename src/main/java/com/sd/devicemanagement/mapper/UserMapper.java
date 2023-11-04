package com.sd.devicemanagement.mapper;

import com.sd.devicemanagement.dto.UserDTO;
import com.sd.devicemanagement.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    List<UserDTO> toDTOs(List<User> users);
}
