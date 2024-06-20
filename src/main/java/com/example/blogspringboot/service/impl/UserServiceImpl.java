package com.example.blogspringboot.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blogspringboot.jwt.JwtTokenUtil;
import com.example.blogspringboot.mapper.UserMapper;
import com.example.blogspringboot.model.bean.User;
import com.example.blogspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // 获取用户的角色，并转换为GrantedAuthority对象
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getPrivilege()));

        // 创建UserDetails对象并设置用户名、密码和权限
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);

        return userDetails;
    }

    @Override
    public ResponseEntity<?> userLogin(String userName, String password) {

        UserDetails userDetails = loadUserByUsername(userName);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()){
            if (passwordEncoder.matches(password,userDetails.getPassword())) {
                final String token = jwtTokenUtil.generateToken(userName);
                // 返回令牌给客户端
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                return ResponseEntity.ok(response);
                // 密码匹配，返回用户信息
            } else {
                // 密码不匹配，返回错误信息
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user.");
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username and password are required.");
        }
        // 检查密码是否匹配

    }
}
