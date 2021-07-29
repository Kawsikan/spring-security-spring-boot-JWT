package com.service.springsecurityjwt.service;

import com.service.springsecurityjwt.domain.Role;
import com.service.springsecurityjwt.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
