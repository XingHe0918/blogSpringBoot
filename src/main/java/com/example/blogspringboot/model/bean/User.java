package com.example.blogspringboot.model.bean;

import lombok.Data;

@Data
public class User {

    private int id;

    private String username;

    private String password;

    private String privilege;

    private String isDelete;

}
