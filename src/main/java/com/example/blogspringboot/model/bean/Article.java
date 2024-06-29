package com.example.blogspringboot.model.bean;


import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Article {

    private int id;

    private String uid;

    private String title;

    private String synopsis;

    private String tag;

    private String category;

    private String content;

    private LocalDate datetime;

    private String readTime;

    private int textNum;

    private String image;

    private String isOpen;

}
