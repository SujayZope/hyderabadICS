package com.registration.login.service;

import com.registration.login.dto.UserDto;
import com.registration.login.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
