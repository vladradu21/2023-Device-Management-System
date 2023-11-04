package com.sd.devicemanagement.service.impl;

import com.sd.devicemanagement.dto.UserDTO;
import com.sd.devicemanagement.exceptions.DmConflictException;
import com.sd.devicemanagement.mapper.UserMapper;
import com.sd.devicemanagement.model.User;
import com.sd.devicemanagement.repository.UserRepository;
import com.sd.devicemanagement.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(String username) {
        if(userRepository.findByUsername(username).isPresent()) {
            throw new DmConflictException("Username already exists");
        }

        User userToSave = new User(username);
        User savedUser = userRepository.save(userToSave);

        return userMapper.toDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    @Transactional
    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }
}
