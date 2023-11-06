package com.sd.devicemanagement.service;

import com.sd.devicemanagement.dto.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public interface UserService {
    UserDTO save(String username);

    List<UserDTO> getAll();

    void delete(String username);
}
