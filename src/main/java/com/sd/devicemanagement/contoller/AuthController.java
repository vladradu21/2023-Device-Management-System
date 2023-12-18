package com.sd.devicemanagement.contoller;

import com.sd.devicemanagement.dto.UserDTO;
import com.sd.devicemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{username}")
    public UserDTO save(@PathVariable String username) {
        return userService.save(username);
    }
}
