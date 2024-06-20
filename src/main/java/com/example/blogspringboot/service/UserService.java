package com.example.blogspringboot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails loadUserByUsername(String username);

    ResponseEntity<?> userLogin(String userName, String password);
}
