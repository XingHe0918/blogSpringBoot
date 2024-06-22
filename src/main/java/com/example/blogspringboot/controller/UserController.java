package com.example.blogspringboot.controller;


import com.example.blogspringboot.model.bean.User;
import com.example.blogspringboot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/userRegister")
    public ResponseEntity<?> userLogin(@RequestBody User loginUser)  {
        return userService.userLogin(loginUser.getUsername(), loginUser.getPassword());
    }

}
