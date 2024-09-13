package com.java.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
