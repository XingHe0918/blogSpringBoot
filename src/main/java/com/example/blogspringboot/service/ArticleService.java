package com.example.blogspringboot.service;

import com.example.blogspringboot.model.bean.Article;

import java.util.List;

public interface ArticleService {

    int addArticle(Article article);

    List<Article> getArticleList();

    Article getArticleById(int id);
}
