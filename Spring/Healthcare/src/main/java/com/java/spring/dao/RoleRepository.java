package com.java.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
