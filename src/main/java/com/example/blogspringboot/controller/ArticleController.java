package com.example.blogspringboot.controller;


import com.example.blogspringboot.model.bean.Article;
import com.example.blogspringboot.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping("/addArticle")
    public int addArticle(@RequestBody Article article){
        return articleService.addArticle(article);
    }

    @PostMapping("getArticleAll")
    public List<Article> getArticleAll(){
        return articleService.getArticleList();
    }

    @PostMapping("getArticleById")
    public Article getArticleById(@RequestBody Map<String, String> map){
        System.out.println(map.get("id"));
        return articleService.getArticleById(Integer.parseInt(map.get("id")));
    }
}
