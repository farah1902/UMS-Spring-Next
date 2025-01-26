package com.saadfarah.user_mngt_system_back.service;

import com.saadfarah.user_mngt_system_back.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();
}
