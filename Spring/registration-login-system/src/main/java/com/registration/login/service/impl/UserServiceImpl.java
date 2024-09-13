package com.registration.login.service.impl;

import com.registration.login.dto.UserDto;
import com.registration.login.entity.Role;
import com.registration.login.entity.User;
import com.registration.login.repository.RoleRepository;
import com.registration.login.repository.UserRepository;
import com.registration.login.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder= passwordEncoder;

    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " "+ userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_CUSTOMER");
        if(role == null)
        {
            role=checkRoleExists();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
    	
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> userDtos = userRepository.findAll().stream().map(
                (user) -> MapToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    private UserDto MapToUserDto(User user)
    {
        UserDto dto = new UserDto();
        String[] str = user.getName().split(" ");
        dto.setFirstName(str[0]);
        dto.setLastName(str[1]);
        dto.setEmail(user.getEmail());
        return dto;

    }

    private Role checkRoleExists()
    {
        Role role = new Role();
        role.setName("ROLE_CUSTOMER");
        return roleRepository.save(role);
    }
}
