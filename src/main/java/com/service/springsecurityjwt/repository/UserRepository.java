package com.service.springsecurityjwt.repository;

import com.service.springsecurityjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

